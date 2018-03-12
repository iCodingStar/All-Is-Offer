package cn.codingstar.offer.lucene;

import org.apache.lucene.document.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.lucene.document.Field.Store.NO;
import static org.apache.lucene.document.Field.Store.YES;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: IndexUtils.java
 * @time: 18-3-12 下午7:20
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class IndexUtils {

    public static List<Document> file2Document(String folderPath) throws IOException {
        List<Document> list = new ArrayList<>();
        File folder = new File(IndexUtils.class.getClassLoader().getResource(folderPath).getPath());
        if (!folder.isDirectory()) {
            return null;
        }
        // 获取目录下所有的文件
        File[] files = folder.listFiles();
        for (File file : files) {
            // 获取文件名称
            String fileName = file.getName();
            System.out.println(file);
            if (fileName.lastIndexOf(".md") > 0) {
                String content = FileUtils.getFileContent(file);
                // 创建文档
                Document document = new Document();

                //创建各个字段域
                Field _fileName = new StringField("fileName", fileName, YES);
                Field _fileContent = new TextField("fileContent", content, NO);
                Field _fileSize = new LongField("fileSize", content.length(), YES);
                Field _filePath = new StringField("filePath", file.getAbsolutePath(), YES);
                // 将各个field添加到文档中
                document.add(_fileName);
                document.add(_fileContent);
                document.add(_fileSize);
                document.add(_filePath);

                // 添加文档
                list.add(document);
            }
        }
        return list;
    }

}
