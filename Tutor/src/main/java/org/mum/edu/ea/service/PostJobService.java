package org.mum.edu.ea.service;

import org.mum.edu.ea.domain.Position;
import org.mum.edu.ea.domain.PositionStatus;
import org.mum.edu.ea.domain.WebUser;
import org.mum.edu.ea.repository.IPostJob;
import org.mum.edu.ea.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Zamuna on 8/11/2017.
 */
@Service
public class PostJobService implements IPostJobService {

    @Autowired
    IPostJob postJobRepo;

    @Override
    @Transactional
    public Position createPosition(Position position) {
        Position position1 = postJobRepo.save(position);
        return position1;
    }

    @Override
    @Transactional
    public Position updatePosition(Position position) {
        Position pos = postJobRepo.save(position);
        return pos;
    }

    @Override
    @Transactional
    public void deletePosition(Position position) {
        postJobRepo.delete(position);
    }

    @Override
    @Transactional
    public Position getPosition(Long id) {
        return postJobRepo.findOne(id);
    }

    @Override
    @Transactional
    public List<Position> getAllPosition() {
        Date dateNow = DateUtils.returnCurrentDate();
        return postJobRepo.findAllByDeadlineAfterAndStatus(dateNow,PositionStatus.ACTIVATE);
    }
 
    @Transactional
    public List<Position> getAllPositions() {
        return postJobRepo.findAll();
    }
    
    
    @Transactional
    public List<Position> getAllMatchsPosition(String keyword) {
    	
        return postJobRepo.findByTitleContaining(keyword);
    }
    
    

    @Override
    public List<Position> getAllPositionPosted(String email) {
        Date dateNow = DateUtils.returnCurrentDate();
        return postJobRepo.findAllByPostedByEqualsAndDeadlineAfterAndStatus(email,dateNow,PositionStatus.ACTIVATE);
    }

    @Override
    public List<Position> getAllPositionApplied(WebUser id) {
        return postJobRepo.findPositionsByWebuserCollectionIsContainingAndStatus(id, PositionStatus.ACTIVATE);
    }

    @Override
    public List<WebUser> getAllUserApplied(Position position) {
        Set<WebUser> appliedUsers=position.getWebuserCollection();
        List<WebUser> list = new ArrayList<WebUser>(appliedUsers);
        System.out.println("--->List of users"+list+"----"+position);
        return list;
    }

}
