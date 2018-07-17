package cdu.xeon.backup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import jcifs.UniAddress;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbSession;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class TestSmb {
	@Test
	public void testPut() {
		try {
			
			String ip = "192.168.101.2";
			UniAddress ua = UniAddress.getByName(ip);
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(ip, "s1", "123");
			SmbSession.logon(ua, auth);
			SmbFile sf = new SmbFile("smb://"+ip+"/samba/goagent-goagent-7805174.zip", auth);
			IOUtils.copyLarge(new FileInputStream("d:/goagent-goagent-7805174.zip"), sf.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SmbException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGet() {
		try {
			
			String ip = "192.168.101.2";
			UniAddress ua = UniAddress.getByName(ip);
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(ip, "s1", "123");
			SmbSession.logon(ua, auth);
			SmbFile sf = new SmbFile("smb://"+ip+"/samba/goagent-goagent-7805174.zip", auth);
			IOUtils.copyLarge(sf.getInputStream(), new FileOutputStream("e:/tt.zip"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SmbException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
