package com.encore.lab1;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class MyMain extends Configured implements Tool {
    public int run(String[] args) throws Exception{
        Job job = Job.getInstance(getConf());
        job.setJobName("wordcount-lab1");
        job.setJarByClass(MyMain.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        job.setMapperClass(MyMap.class);
        job.setReducerClass(MyReduce.class);
        Path inputFilePath = new Path(args[0]);
        Path outputFilePath = new Path(args[1]);
        FileInputFormat.addInputPath(job, inputFilePath);
        FileOutputFormat.setOutputPath(job, outputFilePath);
        return job.waitForCompletion(true) ? 0 : 1; //: job 실행 요청
    }
    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(new MyMain(), args);
        System.exit(exitCode);
    }
}
