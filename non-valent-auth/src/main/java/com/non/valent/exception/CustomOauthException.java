package com.non.valent.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.non.valent.enums.SystemErrorType;
import com.non.valent.vo.ResultVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author haimiyang
 * @date:2020/1/16 11:39
 * @version:1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOauthException extends OAuth2Exception {
    private final ResultVO result;

    CustomOauthException(OAuth2Exception oAuth2Exception) {
        super(oAuth2Exception.getSummary(), oAuth2Exception);
        this.result = ResultVO.fail(SystemErrorType.valueOf(oAuth2Exception.getOAuth2ErrorCode().toUpperCase()), oAuth2Exception);
    }
}
