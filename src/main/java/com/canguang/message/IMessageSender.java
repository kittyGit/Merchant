package com.canguang.message;

import com.canguang.message.dto.Result;
import com.canguang.message.dto.VarsDto;

public interface IMessageSender {

	Result send(String to, VarsDto varDto);
}
