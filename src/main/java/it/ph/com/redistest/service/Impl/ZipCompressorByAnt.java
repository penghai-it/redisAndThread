package it.ph.com.redistest.service.Impl;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

import java.io.File;

public class ZipCompressorByAnt {
    private File zipFile;

    /**
     * 压缩文件构造函数
     */
    public ZipCompressorByAnt(String finalFile) {
        zipFile = new File(finalFile);
    }

    /**
     * 执行压缩操作
     *
     * @param srcPathName 需要被压缩的文件/文件夹
     */
    public void compressExe(String srcPathName) {
        File srcdir = new File(srcPathName);
        if (!srcdir.exists()) {
            throw new RuntimeException(srcPathName + "不存在！");
        }
        Project prj = new Project();
        Zip zip = new Zip();
        zip.setProject(prj);
        zip.setDestFile(zipFile);
        FileSet fileSet = new FileSet();
        fileSet.setProject(prj);
        fileSet.setDir(srcdir);
        zip.addFileset(fileSet);
        zip.execute();
    }

    public static void main(String[] args) {
        ZipCompressorByAnt zca = new ZipCompressorByAnt("E:/GLA/Gitlab_workspace/上报系统/dt_report/四川省.zip");
        zca.compressExe("E:/GLA/Gitlab_workspace/上报系统/dt_report/四川省");
    }
}
