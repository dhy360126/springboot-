package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@SpringBootTest
class SpringbootmoredatasourceApplicationTests {

	@Test
	void contextLoads() {
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis() / 1000;
		try {
			File file = new File("E://log4j//excel.txt");

			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();

			FileOutputStream outStream = new FileOutputStream(file, true);

			StringBuilder builder = new StringBuilder(10240);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH::mm:ss");
			Random rand = new Random();

			String tmpDate = dateFormat.format(new Date());
			Long tmpTimestamp = System.currentTimeMillis() / 1000;

			int i = 0;
			while (i++ < 70000) {
				if (i > 0 && i % 30000 == 0) {
					System.out.println("write offset:" + i);
					outStream.write(builder.toString().getBytes("UTF-8"));
					builder = new StringBuilder(10240);
				}

				if (tmpTimestamp.compareTo(System.currentTimeMillis() / 1000) != 0) {
					tmpDate = dateFormat.format(new Date());
					tmpTimestamp = System.currentTimeMillis() / 1000;
				}

				builder.append(tmpDate);
				builder.append("\t");
				builder.append(rand.nextInt(999));
				builder.append("\t");
				builder.append((System.currentTimeMillis() + "" + rand.nextInt(99999999)));
				builder.append("\t");
				builder.append(rand.nextInt(999) % 2 == 0 ? "AA." : "BB");
				builder.append(rand.nextFloat() * 2000);
				builder.append("\t");
				builder.append(rand.nextInt(9));
				builder.append("\n");
			}

			System.out.println("write data:" + i);
			outStream.write(builder.toString().getBytes("UTF-8"));

			outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() / 1000 - start);

	}

}
