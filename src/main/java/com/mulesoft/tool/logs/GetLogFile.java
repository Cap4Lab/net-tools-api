package com.mulesoft.tool.logs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;

public class GetLogFile implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		String filename = eventContext.getMessage().getProperty("fileName", PropertyScope.INVOCATION);
		Path path = Paths.get(System.getProperty("mule.home"), "logs", filename.replace("/", "").replace("\\", ""));       
		byte[] fileBytes = Files.readAllBytes(path);
		return fileBytes;
	}

}
