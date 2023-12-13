package com.template;
import java.io.IOException;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.simple.ParseTemplateTransformer;
import org.mule.util.IOUtils;

public class DynamicTemplateSelector extends ParseTemplateTransformer{
	private String getTemplate;
	public String getGetTemplate(){
		return getTemplate;
	}
	
	public void setGetTemplate(String getTemplate) {
		this.getTemplate = getTemplate;
	}
	
	@Override
	public void initialise() throws InitialisationException {
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		//@SuppressWarnings("deprecation")
		String location = muleContext.getExpressionManager().parse(getTemplate, message);
		String template;
		try {
			template = IOUtils.getResourceAsString(location, this.getClass());
		} catch (IOException e) {
			throw new TransformerException(this, e);
		}
		return muleContext.getExpressionManager().parse(template, message);
	}

}
