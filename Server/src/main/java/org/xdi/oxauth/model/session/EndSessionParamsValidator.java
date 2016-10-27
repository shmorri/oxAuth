/*
 * oxAuth is available under the MIT License (2008). See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2014, Gluu
 */

package org.xdi.oxauth.model.session;

import org.xdi.oxauth.model.error.ErrorResponseFactory;

/**
 * @author Javier Rojas
 * @author Yuriy Zabrovarnyy
 *
 * Date: 12.15.2011
 */
public class EndSessionParamsValidator {

    public static boolean isValidParams(String param) {
        return param != null && !param.isEmpty();
    }

    public static void validateParams(String idTokenHint, String postLogoutUrl, ErrorResponseFactory errorFactory) {
        if (!isValidParams(idTokenHint) || postLogoutUrl == null || postLogoutUrl.isEmpty()) {
            errorFactory.throwBadRequestException(EndSessionErrorResponseType.INVALID_REQUEST);
        }
    }

    public static void validateParams(String sessionState, ErrorResponseFactory errorFactory) {
        if (!isValidParams(sessionState)) {
            errorFactory.throwBadRequestException(EndSessionErrorResponseType.INVALID_REQUEST);
        }
    }
}