package com.cnu.realcoding.team24.demo.repository;

import com.cnu.realcoding.team24.demo.domain.LeaguePositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentPositionRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public LeaguePositionDTO insertCurrentPositionDB(LeaguePositionDTO positionDTO){
        return mongoTemplate.insert(positionDTO);
    }

    public LeaguePositionDTO findPositionBySummonerId(String summonerId){
        Query query = new Query();

        query.addCriteria(Criteria.where("name").is(summonerId));
        query.with(Sort.by(Sort.Order.desc("_id")));

        return mongoTemplate.findOne(query, LeaguePositionDTO.class);
    }
}
