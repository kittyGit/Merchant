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
				"src/test/resources/generate/二维码.png");

		QRCode.from(
				MessageFormat
						.format("http://192.168.0.102:8080/Merchant/customer/registerInput.action?merchantCode={0}&storeCode={1}",
								"eb4fbd46-7e06-4d2e-8411-30e8d027e2b0", "a5cae0e2-b2e5-4a2a-8533-b0cbadfbff04")).to(ImageType.PNG)
				.withSize(250, 250).withCharset(StandardCharsets.UTF_8.name())
				.writeTo(fos);
	}
}
