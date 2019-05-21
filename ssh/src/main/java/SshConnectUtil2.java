import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SshConnectUtil2 {

	
	public String sshConnect(String command, String path) {
		int BUFFER_SIZE = 4096;
		String username = "srshin";
        String host = "192.168.56.104";
        int port = 22;
        String password = "1234";
        String result = ""; 
        
        System.out.println("==> Connecting to " + host);
        Session session = null;
        Channel channel = null;
     
        // 2. 세션 객체를 생성한다 (사용자 이름, 접속할 호스트, 포트를 인자로 준다.)
        try {
            // 1. JSch 객체를 생성한다.
            JSch jsch = new JSch();
            session = jsch.getSession(username, host, port);
         
            // 3. 패스워드를 설정한다.
            session.setPassword(password);
         
            // 4. 세션과 관련된 정보를 설정한다.
            java.util.Properties config = new java.util.Properties();
            // 4-1. 호스트 정보를 검사하지 않는다.
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
         
            // 5. 접속한다.
            session.connect();
         
            // 6. sftp 채널을 연다.
            channel = session.openChannel("exec");
         
            // 8. 채널을 SSH용 채널 객체로 캐스팅한다
            ChannelExec channelExec = (ChannelExec) channel;
         
            System.out.println("==> Connected to " + host);
            System.out.println(command + " " + path);
            channelExec.setCommand(command +" " +  path);
            
       
            
         // null이면 입력이 없다는 뜻. System.in 을 지정할 경우 스트림이 안 닫히기 때문에 종료가 안되는 듯.
            channelExec.setInputStream(null);
             
            // 출력 스트림을 명시적으로 받아서 처리할 것이므로 설정하지 않는다.
            // channel.setOutputStream(System.out);
            // channel.setErrStream(System.err);
             
            // 출력 스트림을 호출하면 출력 스트림을 끝까지 읽고 처리해줘야 함.
            InputStream inputStream = channelExec.getInputStream(); // <- 일반 출력 스트림
            final InputStream errStream = channelExec.getErrStream();// <- 일반 에러 스트림
            byte[] buffer = new byte[BUFFER_SIZE];
             
            channelExec.connect();
             
            while(true) {
                while (inputStream.available() > 0) {
                    int i = inputStream.read(buffer, 0, BUFFER_SIZE);
                    if (i < 0) {
                        break;
                    }
                    result += new String(buffer, 0, i);
                    System.out.println("inputstream");
                    //System.out.println(new String(buffer, 0, i));
                }
             
                while (errStream.available() > 0) {
                    int i = errStream.read(buffer, 0, BUFFER_SIZE);
                    if (i > 0) {
                        String resultError = new String(buffer, 0, i);
                        //System.err.println(new String(buffer, 0, i));
                        result += resultError; 
                        System.out.println("errstream : " + resultError);
                    }
                }
             
                if (channel.isClosed()) {
                    if (inputStream.available() > 0 || errStream.available() > 0) {
                        continue;
                    }
                    break;
                }
             
                TimeUnit.MILLISECONDS.sleep(100);
            }
             
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if (channel != null) {
                channel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
        final int exitStatus = channel.getExitStatus();
        System.out.println(result);
        System.out.println("Exit Status : " + exitStatus);
        result = result.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
		return result; 
	}
}
