package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetectionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;

    @Column
    private DetectionTypeGroup detectionGroup;

    @OneToMany(mappedBy = "detectionType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Question> questions;

//    @OneToMany(mappedBy = "detectionType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Result> result;


//    ANKSIOZNOST(0),
//    PANICNI_NAPAD(1),
//    SOCIJALNA_ANKSIOZNOST(2),
//    SAD(3),  10
//    DISGUSTED(4), 11
//    ANGRY(5),  12
//    FEARFUL(6),  13
//    BAD(7),  14
//    SURPRISED(8),  15
//    HAPPY(9),  16
//    USLOVI_ZA_ANKSIOZNOST(10),
//    GENERALNI_ANKSIOZNI_POREMECAJ(11),
//    USLOVI_ZA_PANICNI_NAPAD(12),
//    PANICNI_POREMECAJ(13),
//    USLOVI_ZA_SOCIJALNU_ANKSIOZNOST(14),
//    SOCIJALNA_FOBIJA(15);
//
//    private final int value;
//
//    DetectionType(int value) {
//        this.value = value;
//    }
//
//    public static DetectionType valueOf(int value) {
//        switch (value) {
//            case 2: return DetectionType.SOCIJALNA_ANKSIOZNOST;
//            case 1: return DetectionType.PANICNI_NAPAD;
//            case 3: return DetectionType.SAD;
//            case 4: return DetectionType.DISGUSTED;
//            case 5: return DetectionType.ANGRY;
//            case 6: return DetectionType.FEARFUL;
//            case 7: return DetectionType.BAD;
//            case 8: return DetectionType.SURPRISED;
//            case 9: return DetectionType.HAPPY;
//            case 10: return DetectionType.USLOVI_ZA_ANKSIOZNOST;
//            case 11: return DetectionType.GENERALNI_ANKSIOZNI_POREMECAJ;
//            case 12: return DetectionType.USLOVI_ZA_PANICNI_NAPAD;
//            case 13: return DetectionType.PANICNI_POREMECAJ;
//            case 14: return DetectionType.USLOVI_ZA_SOCIJALNU_ANKSIOZNOST;
//            case 15: return DetectionType.SOCIJALNA_FOBIJA;
//            default: return DetectionType.ANKSIOZNOST;
//        }
//    }
}
