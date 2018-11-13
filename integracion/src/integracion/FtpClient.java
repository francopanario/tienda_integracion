package integracion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpClient {

	private FTPClient ftp;

	public void open(String server, int port, String user, String password) throws IOException {
		ftp = new FTPClient();

		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));

		ftp.connect(server, port);
		int reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			throw new IOException("Exception in connecting to FTP Server");
		}

		ftp.login(user, password);
	}

	public void upload(String path,String fileName) throws IOException {
		ftp.storeFile(fileName, new FileInputStream(path));
		
	}

	public void close() throws IOException {
		ftp.disconnect();
	}
}
