package com.horuz.test.helpwebapp.post.service.impl;

import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.post.model.Select;
import com.horuz.test.helpwebapp.post.repository.SelectRepository;
import com.horuz.test.helpwebapp.post.service.SelectService;
import com.horuz.test.helpwebapp.post.utils.MessageUtil;
import com.horuz.test.helpwebapp.security.api.model.CurrUser;
import com.horuz.test.helpwebapp.security.api.service.IdentityApiService;
import com.horuz.test.helpwebapp.security.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SelectServiceImpl implements SelectService {
    private final SelectRepository selectRepository;
    private final IdentityApiService identityApiService;

    @Override
    public void makeSelect(Select select) {
        selectRepository.save(select);
    }

    @Override
    public List<Post> findPostsBySelects(Long user_id) {
        List<Select> byUserId = selectRepository.findByUserId(user_id);

        return byUserId.stream()
                .map(Select::getPost)
                .toList();
    }

    @Override
    public List<Select> findSelectByUser(Long user_id) {
        return selectRepository.findByUserId(user_id);
    }


    @Override
    public List<Select> listSelected(Long id) {
        return selectRepository.findByUserId(id);
    }

    @Override
    public boolean selected(Integer postId) {
        CurrUser currUser = identityApiService.currentUserAccount().orElseThrow(
                () -> new RuntimeException(MessageUtil.USER_NOT_FOUND_NOT_NAME)
        );
        List<Select> byUserId = selectRepository.findByUserId(currUser.id());

        for (Select select : byUserId) {
            Integer id = select.getPost().getId();
            if (id.equals(postId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteSelects(Integer selects) {
        CurrUser currUser = identityApiService.currentUserAccount().orElseThrow(
                () -> new RuntimeException(MessageUtil.USER_NOT_FOUND_NOT_NAME)
        );
        List<Select> byUserId = selectRepository.findByUserId(currUser.id());
        System.out.println(byUserId);

        boolean selectFound = false;
        for (Select select : byUserId) {
            Integer id = select.getPost().getId();
            if (id.equals(selects)) {
                selectRepository.delete(select);
                selectFound = true;
            }
        }
        if (!selectFound) {
            Users users = identityApiService.currentUserAccountUsername(currUser.id()).orElseThrow();
            throw new RuntimeException(
                    String.format(
                            MessageUtil.POST_NOT_FOUND_BY_USER_SELECT,
                            selects,
                            users.getUsername())
            );
        }
    }
}
