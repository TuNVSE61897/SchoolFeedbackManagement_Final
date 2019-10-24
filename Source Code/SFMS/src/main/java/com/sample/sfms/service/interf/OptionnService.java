package com.sample.sfms.service.interf;

import com.sample.sfms.model.option.OptionCreateModel;
import com.sample.sfms.model.option.OptionUpdateModel;

public interface OptionnService {
    int add(OptionCreateModel model) throws Exception;
    void update(OptionUpdateModel model) throws Exception;
    void remove(int id) throws Exception;
}
