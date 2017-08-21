package org.mum.edu.ea.repository;

import javafx.geometry.Pos;
import org.mum.edu.ea.domain.Position;
import org.mum.edu.ea.domain.PositionStatus;
import org.mum.edu.ea.domain.WebUser;
import org.mum.edu.ea.utils.DateUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


/**
 * Created by Zamuna on 8/11/2017.
 */
@Repository
public interface IPostJob extends JpaRepository<Position,Long> {
    List<Position> findAllByStatusEquals(PositionStatus status);
    List<Position> findAllByDeadlineAfterAndStatus(Date date,PositionStatus status);
    List<Position> findAllByPostedByEqualsAndDeadlineAfterAndStatus(String email,Date date,PositionStatus status);
    List<Position> findPositionsByWebuserCollectionIsContainingAndStatus(WebUser id, PositionStatus status);
    List<Position> findDistinctByCategoryContains(String category);
    List<Position> findAllByJobLocationContainingAndStatusEqualsAndDeadlineGreaterThanEqual(String joblocation,String cat,Date date);
    List<Position> findByTitleContaining (String keyword);
}
