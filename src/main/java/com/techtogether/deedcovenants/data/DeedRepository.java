package com.techtogether.deedcovenants.data;

import com.techtogether.deedcovenants.models.Deed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeedRepository extends CrudRepository<Deed, Integer> {
    List<Deed> findAllByAddress(String address);
}
