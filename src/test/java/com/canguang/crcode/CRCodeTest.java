package com.canguang.crcode;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import org.junit.Test;

/**
 * 生成简单的二维码
 * 
 * @author Administrator
 *
 */
public class CRCodeTest {

	@Test
	public void testGenerate() throws Exception {

		FileOutputStream fos = new FileOutputStream(
				"src/test/resources/generate/canguang.png");

		QRCode.from(
				MessageFormat
						.format("http://192.168.0.102:8080/Merchant/customer/registerInput.action?merchantCode={0}&storeCode={1}",
								"123", "1")).to(ImageType.PNG)
				.withSize(250, 250).withCharset(StandardCharsets.UTF_8.name())
				.writeTo(fos);
	}
}
