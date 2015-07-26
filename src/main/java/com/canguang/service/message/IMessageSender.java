package com.canguang.service.message;

import com.canguang.dto.message.Result;
import com.canguang.dto.message.VarsDto;

public interface IMessageSender {

	Result send(String to, VarsDto varDto);
}
