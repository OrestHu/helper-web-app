package com.horuz.test.helpwebapp.post.mapper;

import com.horuz.test.helpwebapp.post.model.Select;
import com.horuz.test.helpwebapp.post.model.req.FindRequest;
import com.horuz.test.helpwebapp.security.mapper.Mapper;

import java.util.List;

public interface FindRequestToListSelectMapper extends Mapper<List<Select>, FindRequest> {
}
