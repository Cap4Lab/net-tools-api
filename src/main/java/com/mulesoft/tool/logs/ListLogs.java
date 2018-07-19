package com.mulesoft.tool.logs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import static java.util.stream.Collectors.toList;

public class ListLogs implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		List<String> filenames = Files.list(Paths.get(System.getProperty("mule.home"), "logs"))
				.filter(Files::isRegularFile)
				.map(Path::getFileName).map(Path::toString).sorted()
				.collect(toList());
		return filenames;
	}

}
