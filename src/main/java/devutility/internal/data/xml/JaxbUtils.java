package devutility.internal.data.xml;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * 
 * JaxbUtils
 * 
 * @author: Aldwin Su
 * @version: 2020-06-29 11:40:04
 */
public class JaxbUtils {
	/**
	 * Convert xml string to Bean.
	 * @param xmlContent Xml content.
	 * @param clazz {@code Class<T> object.}
	 * @return {@code T}
	 * @throws JAXBException from JAXBContext.newInstance
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xmlToBean(String xmlContent, Class<T> clazz) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = context.createUnmarshaller();

		try (Reader reader = new StringReader(xmlContent)) {
			return (T) unmarshaller.unmarshal(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}