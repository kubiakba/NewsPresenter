package pl.bk.news.application.validators;

import pl.bk.news.application.exception.AppException;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static pl.bk.news.application.exception.ErrorCode.INVALID_COUNTRY_NAME;

public class CountryValidator
{
    public static void isNameValid(String country)
    {
        if(stream(Country.values()).noneMatch(c -> c.name().equals(country)))
        {
            throw new AppException(
                "Country with abbreviation: " + country + " is not supported.",
                BAD_REQUEST,
                INVALID_COUNTRY_NAME
            );
        }
    }
    
    private enum Country
    {
        ae, ar, at, au, be, bg, br, ca, ch, cn, co, cu, cz, de, eg, fr, gb, gr, hk, hu, id, ie, il, in, it, jp, kr, lt, lv, ma, mx, my, ng, nl, no, nz, ph, pl, pt, ro, rs, ru, sa, se, sg, si, sk, th, tr, tw, ua, us, ve, za
    }
    
}
