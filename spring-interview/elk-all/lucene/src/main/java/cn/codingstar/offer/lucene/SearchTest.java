package cn.codingstar.offer.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: SearchTest.java
 * @time: 18-3-12 下午8:35
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class SearchTest {

    // 索引目录地址
    private static String indexFolder = "searchIndex";

    private static void testQuery() throws IOException {
        // 创建查询对象，根据文件名称域搜索匹配文件名称的文档
        Query query = new TermQuery(new Term("fileName", "Java 容器.md"));

        // 指定索引目录
        Directory directory = FSDirectory.open(Paths.get("/home/star/Documents/Workspaces/Java/All-Is-Offer/searchIndex"));

        // 定义IndexerReader
        IndexReader reader = DirectoryReader.open(directory);

        // 定义IndexerSearcher
        IndexSearcher searcher = new IndexSearcher(reader);

        // 执行搜索
        TopDocs topDocs = searcher.search(query, 100);
        // 提取搜索结果
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        System.out.println("共搜索到记录 ： " + topDocs.totalHits);

        for (ScoreDoc doc : scoreDocs) {
            // 文档id
            int id = doc.doc;
            // 得到文档
            Document document = searcher.doc(id);
            // 输出文件内容
            System.out.println("doc id " + id);
        }
    }

    public static void main(String[] args) throws IOException {
        testQuery();
    }
}
