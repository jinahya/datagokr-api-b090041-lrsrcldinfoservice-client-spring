package com.github.jinahya.datagokr.api.b090041_.lrsrcldinfoservice.client;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An abstract parent class for client classes.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Slf4j
public abstract class AbstractLrsrCldInfoServiceClient {

    // ------------------------------------------------------------------------------------------------ urls \ constants
    static final String BASE_URL = "http://apis.data.go.kr/B090041/openapi/service/LrsrCldInfoService";

    /**
     * The base url for development environment. The value is {@value}.
     */
    public static final String BASE_URL_DEVELOPMENT = BASE_URL;

    /**
     * The value url for production environment. The value is {@value}.
     */
    public static final String BASE_URL_PRODUCTION = BASE_URL_DEVELOPMENT;

    // --------------------------------------------------------------------------------------------- methods \ constants

    /**
     * A path segment for retrieves lunar dates with a solar date. The value is {@value}.
     */
    public static final String PATH_SEGMENT_GET_LUN_CAL_INFO = "getLunCalInfo";

    /**
     * A path segment for retrieves solar dates with a lunar date. The value is {@value}.
     */
    public static final String PATH_SEGMENT_GET_SOL_CAL_INFO = "getSolCalInfo";

    /**
     * A path segment for retrieves lunar dates for a rage of solar years. The value is {@value}.
     */
    public static final String PATH_SEGMENT_GET_SPCIFY_LUN_CAL_INFO = "getSpcifyLunCalInfo";

    // ------------------------------------------------------------------------------------------ parameters \ constants

    /**
     * A query parameter name for assigned service key. The value is {@value}.
     */
    public static final String QUERY_PARAM_NAME_SERVICE_KEY = "ServiceKey";

    /**
     * A query parameter name for a solar year. The value is {@value}.
     */
    public static final String QUERY_PARAM_NAME_SOL_YEAR = "solYear";

    /**
     * A query parameter name for a solar month. The value is {@value}.
     */
    public static final String QUERY_PARAM_NAME_SOL_MONTH = "solMonth";

    /**
     * A query parameter name for a solar day of month. The value is {@value}.
     */
    public static final String QUERY_PARAM_NAME_SOL_DAY = "solDay";

    /**
     * A query parameter name for a lunar year. The value is {@value}.
     */
    public static final String QUERY_PARAM_NAME_LUN_YEAR = "lunYear";

    /**
     * A query parameter name for a lunar month. The value is {@value}.
     */
    public static final String QUERY_PARAM_NAME_LUN_MONTH = "lunMonth";

    /**
     * A query parameter name for a lunar day of month. The value is {@value}.
     */
    public static final String QUERY_PARAM_NAME_LUN_DAY = "lunDay";

    /**
     * A query parameter name for the starting solar year. The value is {@value}.
     */
    public static final String QUERY_PARAM_NAME_FROM_SOL_YEAR = "fromSolYear";

    /**
     * A query parameter name for the ending solar year. The value is {@value}.
     */
    public static final String QUERY_PARAM_NAME_TO_SOL_YEAR = "toSolYear";

    /**
     * A query parameter name for the flag of leap month. The value is {@value}.
     */
    public static final String QUERY_PARAM_NAME_LEAP_MONTH = "leapMonth";

    /**
     * A query parameter name for the page number. The value is {@value}.
     */
    public static final String QUERY_PARAM_NAME_PAGE_NO = "pageNo";

    // -------------------------------------------------------------------------------------------- injection qualifiers

    /**
     * An injection qualifier for the {@code serviceKey} provided by service provider.
     *
     * @see AbstractLrsrCldInfoServiceClient#QUERY_PARAM_NAME_SERVICE_KEY
     */
    @Qualifier
    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface LrsrCldInfoServiceServiceKey {

    }

    // ---------------------------------------------------------------------------------------------------- constructors

    /**
     * Creates a new instance.
     */
    protected AbstractLrsrCldInfoServiceClient() {
        super();
    }

    // ------------------------------------------------------------------------------------------------- instance fields
    @LrsrCldInfoServiceServiceKey
    @Autowired
    @Accessors(fluent = true)
    @Setter(AccessLevel.NONE)
    @Getter(value = AccessLevel.PROTECTED)
    private String serviceKey;
}
