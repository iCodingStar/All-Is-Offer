package cn.codingstar.offer.lucene;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: IndexerTest.java
 * @time: 18-3-12 下午5:58
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class IndexerTest {

    private static String searchSource = "searchData";

    private static String indexFolder = "searchIndex";


    public static void main(String[] args) {

        try {
            // 从数据目录中读物文件内容并转化成文档
            List<Document> docs = IndexUtils.file2Document(searchSource);
            // 创建标准分析器
            StandardAnalyzer analyzer = new StandardAnalyzer();
            // 指定索引存储目录
            Directory directory = FSDirectory.open(Paths.get(indexFolder));

            // 创建索引操作配置对象
            IndexWriterConfig config = new IndexWriterConfig(analyzer);
            // 定义索引操作对象
            IndexWriter writer = new IndexWriter(directory, config);
            // 清楚以前的index
            writer.deleteAll();

            // 遍历目录下生成的文档，调用indexWriter的方法生成索引
            for (Document document : docs) {
                writer.addDocument(document);
            }
            // 索引操作关闭流
            if (writer != null) {
                writer.commit();
                Map<String, String> map = writer.getCommitData();
                writer.commit();
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
