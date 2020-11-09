package ca.bcit.comp2522.assignments.a4;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

/**
 * BookStoreFactory.
 * Creates a copy of a hardcoded xml file called "bookstore.xml"
 * @author Ben Jones
 * @version 1
 */
public final class BookStoreFactory {

  /**
   * newDoc.
   * new document
   */
  private Document newDoc;
  /**
   * bookDoc.
   * input doc
   */
  private Document bookDoc;
  /**
   * inst.
   * Instance fro singleton
   */
  private static BookStoreFactory inst;

  /**
   * getInstance.
   * returnes instance of BookStoreFactory
   * @return BookStoreFactory
   * @throws ParserConfigurationException
   */
  public static BookStoreFactory getInstance()
      throws ParserConfigurationException {
    if (inst == null) {
      inst = new BookStoreFactory();
    }
    return inst;
  }
  private BookStoreFactory() throws ParserConfigurationException {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = dbf.newDocumentBuilder();
    this.newDoc = builder.newDocument();
  }


  /**
   * getDom.
   * builds and returns new dom file
   * @param file file to build
   * @return Document
   */
  public static Document getDOM(final String file) {
    try {
      File xmlFile = new File(file);
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = dbf.newDocumentBuilder();
      return builder.parse(xmlFile);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  /**
   * createBook.
   * uses Book object to build node
   * @param book Book object
   * @return Node
   */
  private Node createBook(final Book book) {
    Element bookNode = newDoc.createElement("book");
    bookNode.setAttribute("edition", book.getIsbn());
    bookNode.setAttribute("year", book.getYear());
    bookNode.setAttribute("isbn", book.getEdition());
    //name
    Element nameElement = newDoc.createElement("name");
    nameElement.insertBefore(newDoc.createTextNode(book.getBookName()),
        nameElement.getLastChild());
    bookNode.appendChild(nameElement);
    //description
    Element descElement = newDoc.createElement("description");
    descElement.insertBefore(newDoc.createTextNode(book.getBookDescription()),
        descElement.getLastChild());
    bookNode.appendChild(descElement);
    //courseapp
    Element crsAppElement = newDoc.createElement("courseapplicability");
    bookNode.appendChild(crsAppElement);
    //course
    for (int i = 0; i < book.getCourses().size(); i++) {
      Element crsInstElement = newDoc.createElement("course");
      crsInstElement.insertBefore(newDoc.createTextNode(book.getCourses()
              .get(i)), crsInstElement.getLastChild());
      crsInstElement.setAttribute("institute", book.getInstitution().get(i));
      crsAppElement.appendChild(crsInstElement);
    }

    //author
    for (int i = 0; i < book.getAuthors().size(); i += 2) {
      Element authorElement = newDoc.createElement("author");
      authorElement.setAttribute("firstname", book.getAuthors().get(i));
      authorElement.setAttribute("lastname", book.getAuthors().get(i + 1));
      bookNode.appendChild(authorElement);
    }
    //publisher
    Element publisherElement = newDoc.createElement("publisher");
    publisherElement.insertBefore(newDoc.createTextNode(book.getPublisher()),
        publisherElement.getLastChild());
    bookNode.appendChild(publisherElement);
    //price
    Element priceElement = newDoc.createElement("price");
    priceElement.insertBefore(newDoc.createTextNode(book.getPrice()),
        priceElement.getLastChild());
    priceElement.setAttribute("currency", book.getCurrency());
    bookNode.appendChild(priceElement);
    //stock
    Element stockElement = newDoc.createElement("stock");
    bookNode.appendChild(stockElement);
    //category
    Element categoryElement = newDoc.createElement("category");
    categoryElement.insertBefore(newDoc.createTextNode(book.stk
            .getCategory()), categoryElement.getLastChild());
    stockElement.appendChild(categoryElement);
    //copies
    Element copiesInStockElement = newDoc.createElement("copiesinstock");
    copiesInStockElement.insertBefore(newDoc.createTextNode(String.valueOf(book
            .stk.getCopiesInStock())), copiesInStockElement.getLastChild());
    stockElement.appendChild(copiesInStockElement);
    //cover
    Element coverURLElement = newDoc.createElement("coverimage");
    coverURLElement.setAttribute("url", book.stk.getCoverImg());
    stockElement.appendChild(coverURLElement);
    //aval
    Element avalElement = newDoc.createElement("availability");
    avalElement.setAttribute("days", String.valueOf(book.stk.getAvailable()));
    stockElement.appendChild(avalElement);
    return bookNode;
  }

  /**
   * assembleBookstore.
   * uses createBook to build DOM document
   * @return Document
   */
  private Document assembleBookstore() {
    Element bookS = newDoc.createElement("bookstore");
    newDoc.appendChild(bookS);
    Element docEle = bookDoc.getDocumentElement();
    NodeList nList = docEle.getChildNodes();
    for (int i = 0; i < nList.getLength(); i++) {

      if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {

        Element bookEl = (Element) nList.item(i);

        if (bookEl.getNodeName().contains("book")) {
          Book tempBook = new Book();
          tempBook.setIsbn(bookEl.getAttribute("isbn"));
          tempBook.setYear(bookEl.getAttribute("year"));
          tempBook.setEdition(bookEl.getAttribute("edition"));
          tempBook.setBookName(bookEl.getElementsByTagName("name")
              .item(0).getTextContent());
          tempBook.setBookDescription(bookEl.getElementsByTagName("description")
              .item(0).getTextContent());

          NodeList courseList =  bookEl
              .getElementsByTagName("courseapplicability");
          Element crs = (Element) bookEl
              .getElementsByTagName("courseapplicability").item(0);
          for (int j = 0; j < courseList.getLength(); j++) {
            tempBook.pushCourses(courseList.item(j).getTextContent());
            Element crsEl = (Element) courseList.item(0).getChildNodes();
            tempBook.pushInstitution(((Element) crs
                .getElementsByTagName("course")
                .item(0)).getAttribute("institute"));
          }
          NodeList authorNl = bookEl.getElementsByTagName("author");
          for (int k = 0; k < authorNl.getLength(); k++) {
            tempBook.pushAuthors((authorNl
                .item(k)).getAttributes()
                .getNamedItem("firstname").getNodeValue());

            tempBook.pushAuthors(((Element) authorNl
                .item(k)).getAttribute("lastname"));
          }
          System.out.println(authorNl.getLength());

          tempBook.setPublisher(bookEl.getElementsByTagName("publisher")
              .item(0).getTextContent());

          tempBook.setPrice(bookEl.getElementsByTagName("price")
              .item(0).getTextContent());
          tempBook.setCurrency(((Element) bookEl.
              getElementsByTagName("price").item(0))
              .getAttribute("currency"));

          Element stockEl = (Element) bookEl.getElementsByTagName("stock")
              .item(0);

          Book.Stock stock = tempBook.new Stock();

          tempBook.stk.setCategory(stockEl.getElementsByTagName("category")
              .item(0).getTextContent());

          tempBook.stk.setCopiesInStock(Integer.parseInt(stockEl
              .getElementsByTagName("copiesinstock").item(0)
              .getTextContent()));

          tempBook.stk.setCoverImg(((Element) stockEl
              .getElementsByTagName("coverimage")
              .item(0)).getAttribute("url"));

          tempBook.stk.setAvailable(Integer.parseInt(((Element) stockEl
              .getElementsByTagName("availability").item(0))
              .getAttribute("days")));

          Node node = createBook(tempBook);
          bookS.appendChild(node);

        }
      }
    }
    return newDoc;
  }


  /**
   * outputBookstore.
   * builds xml based on newDoc
   * @param outFile name of file to be built
   * @throws TransformerException
   */
  public void outputBookstore(final String outFile)
      throws TransformerException {
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer trans = tf.newTransformer();
    DOMSource source = new DOMSource(newDoc);
    StreamResult result = new StreamResult(new File(outFile));
    trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
    trans.setOutputProperty(OutputKeys.INDENT, "yes");
    trans.setOutputProperty(OutputKeys.STANDALONE, "yes");
    trans.transform(source, result);
  }

  /**
   * duplicateBookstore.
   * uses methods to duplicate xml file
   * @param inFile input xml name
   * @param outFile output xml name
   * @throws TransformerException
   */
  public void duplicateBookstore(final String inFile, final String outFile)
      throws TransformerException {
    bookDoc = getDOM(inFile);
    Document doc = assembleBookstore();
    outputBookstore(outFile);
  }

  /**
   * main.
   * runs program/ instantiates bookstorefactory and runs
   * duplicate bookstore
   * @param args not used
   * @throws TransformerException
   * @throws ParserConfigurationException
   */
  public static void main(final String[] args) throws
      TransformerException, ParserConfigurationException {
    BookStoreFactory bsf = BookStoreFactory.getInstance();
    bsf.duplicateBookstore("bookstore.xml", "bookstore-copy.xml");
  }

  class Book {

    /**
     * bookName.
     */
    String bookName = "";
    /**
     * bookDesctiption.
     */
    String bookDescription = "";
    /**
     * courses.
     */
    ArrayList<String> courses = new ArrayList();
    /**
     * authors.
     */
    ArrayList<String> authors = new ArrayList();
    /**
     * publisher.
     */
    String publisher = "";
    /**
     * price.
     */
    String price = "";
    /**
     * isbn.
     */
    String isbn = "";
    /**
     * year.
     */
    String year = "";
    /**
     * edition.
     */
    String edition = "";
    /**
     * institution.
     */
    ArrayList<String> institution = new ArrayList<>();
    /**
     * currency.
     */
    String currency = "";
    /**
     * stk.
     * Stock object
     */
    Stock stk = new Stock();

    /**
     * getBookName.
     * @return bookName
     */
    public String getBookName() {
      return bookName;
    }
    /**
     * getBookDecription.
     * @return bookDescription
     */
    public String getBookDescription() {
      return bookDescription;
    }
    /**
     * getCourses.
     * @return courses
     */
    public ArrayList<String> getCourses() {
      return courses;
    }
    /**
     * getAuthors.
     * @return authors
     */
    public ArrayList<String> getAuthors() {
      return authors;
    }
    /**
     * getPublisher.
     * @return publisher
     */
    public String getPublisher() {
      return publisher;
    }
    /**
     * getPrice.
     * @return price
     */
    public String getPrice() {
      return price;
    }
    /**
     * getIsbn.
     * @return isbn
     */
    public String getIsbn() {
      return isbn;
    }
    /**
     * getYear.
     * @return year
     */
    public String getYear() {
      return year;
    }
    /**
     * getEdition.
     * @return edition
     */
    public String getEdition() {
      return edition;
    }
    /**
     * getInstitution.
     * @return institution
     */
    public ArrayList<String> getInstitution() {
      return institution;
    }
    /**
     * getCurrency.
     * @return currency
     */
    public String getCurrency() {
      return currency;
    }
    /**
     * setBookName.
     * @param bookNamev name of the book
     */
    public void setBookName(final String bookNamev) {
      this.bookName = bookNamev;
    }
    /**
     * setBookDescription.
     * @param bookDescriptiona description of book
     */
    public void setBookDescription(final String bookDescriptiona) {
      this.bookDescription = bookDescriptiona;
    }
    /**
     * pushCourses.
     * @param coursesa courses
     */
    public void pushCourses(final String coursesa) {
      this.courses.add(coursesa);
    }
    /**
     * pushAuthors.
     * @param authorsa author of book
     */
    public void pushAuthors(final String authorsa) {
      this.authors.add(authorsa);
    }
    /**
     * setPublisher.
     * @param publishera books publisher
     */
    public void setPublisher(final String publishera) {
      this.publisher = publishera;
    }
    /**
     * setPrice.
     * @param pricea book price
     */
    public void setPrice(final String pricea) {
      this.price = pricea;
    }
    /**
     * setIsbn.
     * @param isbna isbn of book
     */
    public void setIsbn(final String isbna) {
      this.isbn = isbna;
    }
    /**
     * setYear.
     * @param yeara year of publishing
     */
    public void setYear(final String yeara) {
      this.year = yeara;
    }
    /**
     * setEdition.
     * @param editiona books edition
     */
    public void setEdition(final String editiona) {
      this.edition = editiona;
    }
    /**
     * pushIstitution.
     * @param institutiona course inst
     */
    public void pushInstitution(final String institutiona) {
      this.institution.add(institutiona);
    }
    /**
     * setCurrency.
     * @param currencya currency of price
     */
    public void setCurrency(final String currencya) {
      this.currency = currencya;
    }

    /**
     * Stock class.
     */
    class Stock {
      /**
       * category.
       * book category
       */
      String category = "";
      /**
       * copiesInStock.
       * amount of copies
       */
      int copiesInStock = 0;
      /**
       * coverImg.
       * cover image url
       */
      String coverImg = "";
      /**
       * available.
       * amt of books avail
       */
      int available = 0;

      /**
       * srtCategory.
       * @param categorya book category
       */
      public void setCategory(final String categorya) {
        this.category = categorya;
      }
      /**
       * setCopiesInStock.
       * @param copiesInStocka amt of copies in stock
       */
      public void setCopiesInStock(final int copiesInStocka) {
        this.copiesInStock = copiesInStocka;
      }
      /**
       * setCoverImg.
       * @param coverImga url of cover img
       */
      public void setCoverImg(final String coverImga) {
        this.coverImg = coverImga;
      }
      /**
       * setAvailable.
       * @param availablea amt available
       */
      public void setAvailable(final int availablea) {
        this.available = availablea;
      }
      /**
       * getCategory.
       * @return category
       */
      public String getCategory() {
        return category;
      }
      /**
       * getCopiesInStock.
       * @return copies in stock
       */
      public int getCopiesInStock() {
        return copiesInStock;
      }
      /**
       * getCoverImg.
       * @return coverImg
       */
      public String getCoverImg() {
        return coverImg;
      }
      /**
       * getAvailable.
       * @return available
       */
      public int getAvailable() {
        return available;
      }
    }

  }



}
