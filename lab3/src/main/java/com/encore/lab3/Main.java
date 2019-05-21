package com.encore.lab3;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class Main {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		// 행렬의 크기를 설정해줍니다.
		conf.set("m", "2");
		conf.set("n", "5");
		conf.set("p", "3");

		Job job = new Job(conf, "MatrixMultiplication");
		job.setJarByClass(Main.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		// 하둡 분산 프로그램을 실행한다.
		job.waitForCompletion(true);
	}
}
