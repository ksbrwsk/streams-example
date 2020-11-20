package de.ksbrwsk.streams;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;

@Log4j2
public class EinTest {
    @Test
    void test() {
        List<Partner> partnerList = Fixtures.createPartnerList();
        partnerList
                .stream()
                .collect(groupingBy(Partner::getGeschlecht))
                .entrySet()
                .forEach(log::info);
    }
}
