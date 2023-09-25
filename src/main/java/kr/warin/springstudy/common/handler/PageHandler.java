package kr.warin.springstudy.common.handler;

import kr.warin.springstudy.common.base.ResultCode;
import kr.warin.springstudy.common.exceptions.EntityDataNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageHandler {

    public static Pageable createAndValid(int page, int size) {
        int pageSize = switch (size) {
            case 10 -> 10;
            case 30 -> 30;
            case 50 -> 50;
            case 100 -> 100;
            default -> throw new EntityDataNotFoundException(ResultCode.PAGE_OVER_FLOW);
        };
        return PageRequest.of(page, pageSize);
    }
}
