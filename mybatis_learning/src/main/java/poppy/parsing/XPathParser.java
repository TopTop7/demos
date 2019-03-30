package poppy.parsing;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.Reader;
import java.util.Properties;

public class XPathParser {
    /**
     * DOM文件
     */
    private final Document document;
    /**
     * 是否开启验证
     */
    private boolean validation;
    /**
     *实体解析器 加载DTD文档：DTD是对XML的一种约束文档，另外一种约束文档 XML Schema （.xsd）
     *该接口的默认实现 XMLMapperEntityResolver
     */
    private EntityResolver entityResolver;
    /**
     * 对应mybatis-config.xml中properties标签
     */
    private Properties variables;
    /**
     * xpath对象，查询dom树
     */
    private XPath xpath;

    public XPathParser(Document document) {
        commonConstructor(validation, variables, entityResolver);
        this.document = document;
    }

    public XPathParser(Reader reader, boolean validation, Properties variables, EntityResolver entityResolver) throws Exception {
        commonConstructor(validation, variables, entityResolver);
        this.document = createDocument(new InputSource(reader));
    }


    /**
     * 创建文档对象
     * @param inputSource
     * @return
     * @throws Exception
     */
    private Document createDocument(InputSource inputSource) throws Exception {
        // 省略异常捕获
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(validation);

        factory.setNamespaceAware(false);
        factory.setIgnoringComments(true);
        factory.setIgnoringElementContentWhitespace(false);
        factory.setCoalescing(false);
        factory.setExpandEntityReferences(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setEntityResolver(entityResolver);
        return builder.parse(inputSource);
        //省略错误处理器
    }

    /**
     * 初始化时调用公共的构造器，构造器中初始化了除Document对象之外的其他成员
     * @param validation
     * @param variables
     * @param entityResolver
     */
    private void commonConstructor(boolean validation, Properties variables, EntityResolver entityResolver) {
        this.validation = validation;
        this.entityResolver = entityResolver;
        this.variables = variables;
        XPathFactory factory = XPathFactory.newInstance();
        this.xpath = factory.newXPath();
    }
}
