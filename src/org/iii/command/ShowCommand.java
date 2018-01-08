package org.iii.command;


import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.iii.domain.Hospital;
import org.iii.domain.Message;

public class ShowCommand extends Command {

	private static ShowCommand showCommand;

	public static synchronized Command getInstanceByMessage(Message message, Hospital hospital) {
		if (showCommand == null) {
			showCommand = new ShowCommand();
		}

		showCommand.setMessage(message);
		showCommand.setHospital(hospital);

		// ¸ÑªRMessage : show
		return showCommand;
	}

	@Override
	public void execute() {
		// Console log
		for (String log : this.getHospital().dumpLog()) {
			System.out.println(log);
		}
	}

}
