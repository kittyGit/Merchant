package com.canguang.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.text.MessageFormat;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.canguang.service.ICaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

@Service
public class CaptchaService implements ICaptchaService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CaptchaService.class);

	@Value("${captcha.image.type}")
	private String imageType;

	private MediaType imageMediaType;

	@Autowired
	private ImageCaptchaService generator;

	@PostConstruct
	public void postConstruct() {
		imageMediaType = MediaType.valueOf(MessageFormat.format("image/{0}",
				imageType));
	}

	@Override
	public ByteArrayOutputStream getCaptchaStream(String captchaId,
			Locale locale) {
		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		try {
			BufferedImage challenge = generator.getImageChallengeForID(
					captchaId, locale);
			ImageIO.write(challenge, imageType, jpegOutputStream);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
		return jpegOutputStream;
	}

	@Override
	public boolean validateResponseForID(String id, String response) {
		return generator.validateResponseForID(id, response);
	}

	@Override
	public MediaType getImageMediaType() {
		return imageMediaType;
	}
}
