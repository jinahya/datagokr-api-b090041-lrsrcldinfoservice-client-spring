package com.github.jinahya.datagokr.api.b090041_.lrsrcldinfoservice.client.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Objects;

/**
 * A class for binding {@code /:response/:header} part.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
@Slf4j
public class Header implements Serializable {

    private static final long serialVersionUID = -3266148101861301931L;

    /**
     * A value of successful {@code :/resultCode}. The value is {@value}.
     */
    public static final String RESULT_CODE_SUCCESS = "00";

    @Override
    public String toString() {
        return super.toString() + '{'
               + "resultCode=" + resultCode
               + ",resultMsg=" + resultMsg
               + '}';
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Header that = (Header) obj;
        return Objects.equals(resultCode, that.resultCode)
               && Objects.equals(resultMsg, that.resultMsg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultCode, resultMsg);
    }

    @JsonIgnore
    @XmlTransient
    public boolean isResultCodeSuccess() {
        return RESULT_CODE_SUCCESS.equals(resultCode);
    }

    @JsonProperty(required = true)
    @NotBlank
    @XmlElement(required = true)
    private String resultCode;

    @JsonProperty(required = true)
    @NotBlank
    @XmlElement(required = true)
    private String resultMsg;
}
