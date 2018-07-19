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
		Path path = Paths.get(System.getProperty("mule.home"), "logs",eventContext.getMessage().getProperty("fileName", PropertyScope.INVOCATION));       
		byte[] fileBytes = Files.readAllBytes(path);
		return fileBytes;
	}

}
