package com.jxnu.demo.tool;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;


public class SFTPUTIL {

    static Session sshSession = null;

    /**
     * 获取ChannelSftp
     */
    public static ChannelSftp getConnectIP(String host, String sOnlineSftpPort, String username, String password) {
        int port = 0;
        if (!("".equals(sOnlineSftpPort)) && null != sOnlineSftpPort) {
            port = Integer.parseInt(sOnlineSftpPort);
        }
        ChannelSftp sftp = null;
        try {
            JSch jsch = new JSch();
            jsch.getSession(username, host, port);
            sshSession = jsch.getSession(username, host, port);
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sftp;
    }

    /**
     * 上传
     */
    public static void upload(String directory, InputStream uploadFile,String name, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            sftp.put(uploadFile, name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sftp.isConnected()) {
                sshSession.disconnect();
                sftp.disconnect();
            }

        }
    }

    /**
     * 下载
     */
    public static void download(String directory, String downloadFile, String saveFile, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            File file = new File(saveFile);
            sftp.get(downloadFile, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sftp.isConnected()) {
                sshSession.disconnect();
                sftp.disconnect();
            }

        }
    }

    /**
     * 查看
     */
    public static List<String> check(String directory, ChannelSftp sftp) {
        List<String> fileList = new ArrayList<>();
        try {
            sftp.cd(directory);
            ListIterator a = sftp.ls(directory).listIterator();
            while (a.hasNext()) {
                fileList.add((String) a.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sftp.isConnected()) {
                sshSession.disconnect();
                sftp.disconnect();
            }

        }
        return fileList;
    }

    /**
     * 删除
     */
    public static void delete(String directory, String deleteFile, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            sftp.rm(deleteFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sftp.isConnected()) {
                sshSession.disconnect();
                sftp.disconnect();
            }

        }
    }



}
