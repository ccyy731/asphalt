package com.nine.utils.calculatin;

import com.nine.vo.CalcaulationPointVo;
import com.nine.vo.LoadVo;
import com.nine.vo.StressAndStrainCalcalationVo;
import com.nine.vo.StructuralLayerVo;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 应力应变计算
 */
@Slf4j
public class StressAndStrainCalculation {

    private File file;

    /**
     * 按照指定格式写一个计算需要的输入文件
<<<<<<< HEAD
=======
     *
>>>>>>> df81d7e136f307dbc211b9063af90195bef9aa8b
     * @param vo
     */
    public void writeFile(StressAndStrainCalcalationVo vo) {
        try {

//            String path = this.file.getAbsolutePath();
            String path = "D:\\graduate\\group\\项目\\应力应变计算相关资料\\应力应变计算";
            String fileName = path+"\\Apbidat-test";

            // 处理多个层位的数据
            List<StructuralLayerVo> layers = vo.getStructuralLayers();
            List<String> layerLists = layers.stream().map(layer -> {
                return layer.getModulus() + "," + layer.getPoissonRatio() + "," + layer.getThickness() + "," + layer.getInterfaceContactCoefficient() + "\n";
            }).collect(Collectors.toList());
            // 将层位列表里的所有数据都取出来进行拼接
            String layerStr = "";
            for (int i = 0; i < layerLists.size(); i++) {
                layerStr+=layerLists.get(i);
            }

            // 处理多个荷载的数据
            List<LoadVo> loads = vo.getLoads();
            List<String> loadLists = loads.stream().map(load -> {
                return load.getUnitPressure() + "," + load.getLoadRadius() + "," + load.getPositionX() + "," + load.getPositionY() + "\n";
            }).collect(Collectors.toList());
            // 将荷载列表里的所有数据都取出来进行拼接
            String loadStr = "";
            for (int i = 0; i < layerLists.size(); i++) {
                loadStr+=loadLists.get(i);
            }

/*            // 处理多个计算点号的数据
            List<CalcaulationPointVo> points = vo.getCalcaulationPoints();
            List<String> a = points.stream().map(p -> {
                return p.getUnitPressure() + "," + load.getLoadRadius() + "," + load.getPositionX() + "," + load.getPositionY() + "\n";
            }).collect(Collectors.toList());
            // 将计算点号列表里的所有数据都取出来进行拼接
            String loadStr = null;
            for (int i = 0; i < layerLists.size(); i++) {
                loadStr+=loadLists.get(i);
            }*/

            String content = vo.getSNum()+"\n"
                    +vo.getLayerNum()+"\n"
                    +layerStr
                    +vo.getLoadNum()+",0\n"
                    +loadStr
                    +vo.getCalcalationNum()+"\n";

            /**
             * 需要写的数据如下：
=======
            String path = "D:\\graduate\\group\\项目\\应力应变计算相关资料\\应力应变计算";
            String fileName = path + "\\Apbidat";

            // 处理多个层位的数据，计算时厚度的单位是cm，前端是mm，需要转换一下单位
            List<StructuralLayerVo> layers = vo.getStructuralLayers();

            // 将每一层的结构数据进行拼接
            String layerStr = "";
            for (StructuralLayerVo layer : layers) {
                layerStr += layer.getModulus() + "," + layer.getPoissonRatio() + "," + (layer.getThickness() == null ? 0 : layer.getThickness() / 10) + "," + (layer.getInterfaceContactCoefficient() == null ? 0 : layer.getInterfaceContactCoefficient()) + "\n";
            }


            // 处理多个荷载的数据，位置可以考虑设默认值
            List<LoadVo> loads = vo.getLoads();
            // 将所有荷载数据进行拼接
            String loadStr = "";
            for (LoadVo load : loads) {
                loadStr += load.getUnitPressure() + "," + load.getLoadRadius() + "," + (load.getPositionX() == null ? 0 : load.getPositionX()) + "," + (load.getPositionY() == null ? 0 : load.getPositionY()) + "\n";
            }

            // 循环产生各个计算点位信息
            String cal = "";
            // 设置总厚度，即z的位置
            Integer positionZ = 0;

            // 处理前五层的数据，每层有两行数据
            for (int k = 0; k < 5; k++) {

                if (0 == k) {
                    positionZ = vo.getStructuralLayers().get(k).getThickness() / 10;
                } else {
                    positionZ += vo.getStructuralLayers().get(k).getThickness() / 10;
                }

                for (int j = 0; j < 2; j++) {
                    if (0 == j) {
                        cal += k + 1          // 层位，从1开始
                                + ","
                                + 15.975    // x的位置
                                + ","
                                + 0         // y的位置
                                + ","
                                + positionZ   // z的位置
                                + "\n";
                    } else {
                        cal += k + 1
                                + ","
                                + 0
                                + ","
                                + 0
                                + ","
                                + positionZ
                                + "\n";
                    }
                }
            }

            // 处理第六层的数据，共十行
            for (int k = 0; k < 10; k++) {
                if (k % 2 == 0) {
                    if (k < 6) {
                        positionZ += 30;
                        cal += 6          // 层位，从1开始
                                + ","
                                + 15.975    // x的位置
                                + ","
                                + 0         // y的位置
                                + ","
                                + positionZ // z的位置
                                + "\n";
                    } else {
                        positionZ += 20;
                        cal += 6           // 层位，从1开始
                                + ","
                                + 15.975    // x的位置
                                + ","
                                + 0         // y的位置
                                + ","
                                + positionZ   // z的位置
                                + "\n";
                    }

                } else {
                    if (k < 6) {
                        cal += 6
                                + ","
                                + 0
                                + ","
                                + 0
                                + ","
                                + positionZ
                                + "\n";
                    } else {
                        cal += 6
                                + ","
                                + 0
                                + ","
                                + 0
                                + ","
                                + positionZ
                                + "\n";
                    }
                }
            }

            String content = vo.getStructuralNum() + "\n"
                    + vo.getLayerNum() + "\n"
                    + layerStr
                    + vo.getLoadNum() + ",0\n"
                    + loadStr
                    + vo.getCalcalationNum() + "\n"
                    + cal;

            /**
             * 需要写的数据结构如下：
>>>>>>> df81d7e136f307dbc211b9063af90195bef9aa8b
             * 1	#结构编号，不能是0或者为空，可默认为1
             * 6	#层位是一共6层，每列的数据分别代表模量、泊桑比、厚度、界面接触系数，结果文件里的界面连续状态前五层都是完全连续（0），第6层是路基参数
             * 10000.,0.25,4.,0.
             * 9000.,0.25,6.,0.
             * ...
             * 60.,0.4
             * 2,0		#荷载号，有两个，指定单位压力、荷载半径、x、y的位置
             * 0.707,10.65,0.0,0.0
             * 0.707,10.65,31.8,0.0
             * 20		#计算点号，共有20个，第一列指层位（1-6），后面三列指的是xyz的位置信息
             * 1,15.975,0.0,4.0
             * 1,0.,0.0,4.0
             * 2,15.975,0.0,10.0
             * 2,0.,0.0,10.0
             * ...
             * 5,15.975,0.0,76.0
             * 5,0.,0.0,76.0
             * 6,15.975,0.0,106.0
             * 6,0.,0.0,106.0
             * 6,15.975,0.0,136.0
             * 6,0.,0.0,136.0
             * 6,15.975,0.0,166.0
             * 6,0.,0.0,166.0
             * 6,15.975,0.0,186.0
             * 6,0.,0.0,186.0
             * 6,15.975,0.0,206.0
             * 6,0.,0.0,206.0
             */

            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(content);
            bw.close();
            System.out.println("-----------写入结束-----------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用应力应变计算程序进行计算
<<<<<<< HEAD
=======
     *
>>>>>>> df81d7e136f307dbc211b9063af90195bef9aa8b
     * @param cmd 指定要调用的.exe程序所在位置的绝对路径
     */
    public void calculation(String cmd) {
        BufferedReader br = null;
        BufferedReader brError;
        String line = null;
        try {
            ProcessBuilder pb = new ProcessBuilder(cmd);

            // 设置此进程生成器的工作目录
            pb.directory(new File("D:\\graduate\\group\\项目\\应力应变计算相关资料\\应力应变计算"));
            // 返回此进程生成器的工作目录
            this.file = pb.directory();
            String path = this.file.getAbsolutePath();
            System.out.println("路径为：" + path);

            // 使用此进程生成器的属性启动一个新进程
            Process p = pb.start();
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            brError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = br.readLine()) != null || (line = brError.readLine()) != null) {
                // 将标准输入流和错误输入流合并,输出exe输出的信息以及错误信息
                log.info(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 读取文件内容
<<<<<<< HEAD
=======
     *
>>>>>>> df81d7e136f307dbc211b9063af90195bef9aa8b
     * @param cs 指定编码格式，输出的结果文件是ansi编码格式，需要转为gbk格式避免乱码
     * @throws IOException
     */
    public void readByBufferedReader(String cs) throws IOException {
        String path = this.file.getAbsolutePath();

        String fileName = path+"\\apbiout";

        // 输出文件的绝对路径
        System.out.println("path："+path);
        System.out.println("fileName："+fileName);

        String fileName1 = path + "\\apbiout";

        // 输出文件的绝对路径
        System.out.println("path：" + path);
        System.out.println("fileName：" + fileName1);


        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, cs);
        BufferedReader br = new BufferedReader(isr);
        String line;
        System.out.println("-----------开始读取文件-----------");
        while ((line = br.readLine()) != null) {
            // 输出文件内容
            System.out.println(line);
        }
        br.close();
    }

}
