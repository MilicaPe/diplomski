insert into role(name) values ('PSIHOLOG');
insert into role(name) values ('KLIJENT');

insert into privileges (name) values ('emotion5');--1
insert into privileges (name) values ('logout');--2
insert into privileges (name) values ('emotion_questions');--3
insert into privileges (name) values ('emotion_survey');--4
insert into privileges (name) values ('emotion_history');--5
insert into privileges (name) values ('emotion_answers');--6
insert into privileges (name) values ('search_for_psychologist');--7
insert into privileges (name) values ('get_psychologist');--8
insert into privileges (name) values ('add_psychologist');--9
insert into privileges (name) values ('remove_psychologist');--10

insert into privileges (name) values ('diagnostic_answer_post');--11
insert into privileges (name) values ('diagnostic_answer_get');--12
insert into privileges (name) values ('diagnostic_answer_get_id');--13
insert into privileges (name) values ('question_get');--14
insert into privileges (name) values ('report_user');--15
insert into privileges (name) values ('report_job');--16
insert into privileges (name) values ('report_detection');--17
insert into privileges (name) values ('user_clients');--18
insert into privileges (name) values ('user_job');--19

insert into user_role_privilege (privilege_id, role_id) values (1, 2);
insert into user_role_privilege (privilege_id, role_id) values (2, 2);
insert into user_role_privilege (privilege_id, role_id) values (2, 1);
insert into user_role_privilege (privilege_id, role_id) values (3, 2);
insert into user_role_privilege (privilege_id, role_id) values (4, 2);
insert into user_role_privilege (privilege_id, role_id) values (5, 1);
insert into user_role_privilege (privilege_id, role_id) values (5, 2);
insert into user_role_privilege (privilege_id, role_id) values (6, 1);
insert into user_role_privilege (privilege_id, role_id) values (6, 2);
insert into user_role_privilege (privilege_id, role_id) values (7, 2);
insert into user_role_privilege (privilege_id, role_id) values (8, 2);
insert into user_role_privilege (privilege_id, role_id) values (9, 2);
insert into user_role_privilege (privilege_id, role_id) values (10, 2);
insert into user_role_privilege (privilege_id, role_id) values (11, 2);
insert into user_role_privilege (privilege_id, role_id) values (12, 1);
insert into user_role_privilege (privilege_id, role_id) values (12, 2);
insert into user_role_privilege (privilege_id, role_id) values (13, 1);
insert into user_role_privilege (privilege_id, role_id) values (13, 2);
insert into user_role_privilege (privilege_id, role_id) values (14, 1);
insert into user_role_privilege (privilege_id, role_id) values (14, 2);
insert into user_role_privilege (privilege_id, role_id) values (15, 1);
insert into user_role_privilege (privilege_id, role_id) values (16, 1);
insert into user_role_privilege (privilege_id, role_id) values (17, 1);
insert into user_role_privilege (privilege_id, role_id) values (18, 1);
insert into user_role_privilege (privilege_id, role_id) values (19, 1);


insert into detection_type(type, detection_group) values ('USLOVI_ZA_ANKSIOZNOST', 1);--1
insert into detection_type(type, detection_group) values ('ANKSIOZNOST', 1);--2
insert into detection_type(type, detection_group) values ('GENERALNI_ANKSIOZNI_POREMECAJ', 1);--3

insert into detection_type(type, detection_group) values ('USLOVI_ZA_PANICNI_NAPAD', 1);--4
insert into detection_type(type, detection_group) values ('PANICNI_NAPAD', 1);--5
insert into detection_type(type, detection_group) values ('PANICNI_POREMECAJ', 1);--6

insert into detection_type(type, detection_group) values ('USLOVI_ZA_SOCIJALNU_ANKSIOZNOST', 1);--7
insert into detection_type(type, detection_group) values ('SOCIJALNA_ANKSIOZNOST', 1);--8
insert into detection_type(type, detection_group) values ('SOCIJALNA_FOBIJA', 1);--9

insert into detection_type(type, detection_group) values ('SAD', 0);--10
insert into detection_type(type, detection_group) values ('DISGUSTED', 0);--11
insert into detection_type(type, detection_group) values ('ANGRY', 0);--12
insert into detection_type(type, detection_group) values ('FEARFUL', 0);--13
insert into detection_type(type, detection_group) values ('BAD', 0);--14
insert into detection_type(type, detection_group) values ('SURPRISED', 0);--15
insert into detection_type(type, detection_group) values ('HAPPY', 0);--16

insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('USLOVI_ZA_ANKSIOZNOST', 'FIRST', 'BLAGO', 1, 7, true, 'Nemate uslova za anksioznost. Nemate razloga za brigu.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('USLOVI_ZA_ANKSIOZNOST', 'FIRST', 'UMERENO', 8, 14, true, 'Nemate uslova za anksioznost. Nemate razloga za brigu.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('USLOVI_ZA_ANKSIOZNOST', 'FIRST', 'IZRAZENO', 15, 19, true, 'Nemate uslova za anksioznost. Nemate razloga za brigu.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('USLOVI_ZA_ANKSIOZNOST', 'FIRST', 'TESKO', 20, 26, false, 'Primećeni su uslovi za anksioznost. Naredni set pitanja će sadržati i pitanja o anksioznosti.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('USLOVI_ZA_ANKSIOZNOST', 'FIRST', 'DUBOKO', 27, 30, false, 'Primećeni su uslovi za anksioznost. Naredni set pitanja će sadržati i pitanja o anksioznosti.');

insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('USLOVI_ZA_PANICNI_NAPAD', 'FIRST', 'BLAGO', 1, 7, true, 'Nemate uslova za panični napad. Nemate razloga za brigu.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('USLOVI_ZA_PANICNI_NAPAD', 'FIRST', 'UMERENO', 8, 14, true, 'Nemate uslova za panični napad. Nemate razloga za brigu.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('USLOVI_ZA_PANICNI_NAPAD', 'FIRST', 'IZRAZENO', 15, 19, true, 'Nemate uslova za panični napad. Nemate razloga za brigu.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('USLOVI_ZA_PANICNI_NAPAD', 'FIRST', 'TESKO', 20, 26, false, 'Primećeni su uslovi za panični napad. Naredni set pitanja će sadržati i pitanja o paničnom napadu.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('USLOVI_ZA_PANICNI_NAPAD', 'FIRST', 'DUBOKO', 27, 30, false, 'Primećeni su uslovi za panični napad. Naredni set pitanja će sadržati i pitanja o paničnom napadu.');

insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('USLOVI_ZA_SOCIJALNU_ANKSIOZNOST', 'FIRST', 'BLAGO', 1, 7, true, 'Nemate uslova za socijalnu anksioznost. Nemate razloga za brigu.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('USLOVI_ZA_SOCIJALNU_ANKSIOZNOST', 'FIRST', 'UMERENO', 8, 14, true, 'Nemate uslova za socijalnu anksioznost. Nemate razloga za brigu.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('USLOVI_ZA_SOCIJALNU_ANKSIOZNOST', 'FIRST', 'IZRAZENO', 15, 19, true, 'Nemate uslova za socijalnu anksioznost. Nemate razloga za brigu.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('USLOVI_ZA_SOCIJALNU_ANKSIOZNOST', 'FIRST', 'TESKO', 20, 26, false, 'Primećeni su uslovi za socijalnu anksioznost. Naredni set pitanja će sadržati i pitanja o socijalnoj anksioznosti.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('USLOVI_ZA_SOCIJALNU_ANKSIOZNOST', 'FIRST', 'DUBOKO', 27, 30, false, 'Primećeni su uslovi za socijalnu anksioznost. Naredni set pitanja će sadržati i pitanja o socijalnoj anksioznosti.');

insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('ANKSIOZNOST', 'SECOND', 'BLAGO', 1, 30, true, 'Detektovana je blaga anksioznost.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('ANKSIOZNOST', 'SECOND', 'UMERENO', 31, 61, true, 'Detektovana je umerena anksioznost.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('ANKSIOZNOST', 'SECOND', 'IZRAZENO', 62, 82, true, 'Detektovana je izražena anksioznost koja nije u domenu patologije.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('ANKSIOZNOST', 'SECOND', 'TESKO', 83, 114, false, 'Dijagnostikovana je anksioznost visokog stepena i naredni set pitanja će sadržati pitanja o generalnom anksioznom poremećaju.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('ANKSIOZNOST', 'SECOND', 'DUBOKO', 115, 130, false, 'Dijagnostikovana je anksioznost visokog stepena i naredni set pitanja će sadržati pitanja o generalnom anksioznom poremećaju.');

insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('PANICNI_NAPAD', 'SECOND', 'BLAGO', 1, 10, true, 'Vaša panika je blaga.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('PANICNI_NAPAD', 'SECOND', 'UMERENO', 11, 21, true, 'Vaša panika je umerena.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('PANICNI_NAPAD', 'SECOND', 'IZRAZENO', 22, 28, true, 'Vaša panika je izražena i nije u domenu patologije.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('PANICNI_NAPAD', 'SECOND', 'TESKO', 29, 39, false, 'Dijagnostikovan je panični napad i naredni set pitanja će sadržati pitanja o paničnom poremećaju.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('PANICNI_NAPAD', 'SECOND', 'DUBOKO', 40, 45, false, 'Dijagnostikovan je panični napad i naredni set pitanja će sadržati pitanja o paničnom poremećaju.');

insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('SOCIJALNA_ANKSIOZNOST', 'SECOND', 'BLAGO', 1, 9, true, 'Detektovana je blaga socijalna anksioznost.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('SOCIJALNA_ANKSIOZNOST', 'SECOND', 'UMERENO', 10, 18, true, 'Detektovana je umerena socijalna anksioznost.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('SOCIJALNA_ANKSIOZNOST', 'SECOND', 'IZRAZENO', 19, 25, true, 'Detektovana je izražena socijalna anksioznost koja nije u domenu patologije.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('SOCIJALNA_ANKSIOZNOST', 'SECOND', 'TESKO', 26, 35, false, 'Dijagnostikovana je socijalna anksioznost visokog stepena i naredni set pitanja će sadržati pitanja o socijalnoj fobiji.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
    values ('SOCIJALNA_ANKSIOZNOST', 'SECOND', 'DUBOKO', 36, 40, false, 'Dijagnostikovana je socijalna anksioznost visokog stepena i naredni set pitanja će sadržati pitanja o socijalnoj fobiji.');

insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
values ('GENERALNI_ANKSIOZNI_POREMECAJ', 'THIRD', 'BLAGO', 1, 13, true, 'Nemate naznake generalnog anksioznog poremećaja.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
values ('GENERALNI_ANKSIOZNI_POREMECAJ', 'THIRD', 'UMERENO', 14, 28, true, 'Nemate naznake generalnog anksioznog poremećaja.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
values ('GENERALNI_ANKSIOZNI_POREMECAJ', 'THIRD', 'IZRAZENO', 29, 37, true, 'Nemate naznake generalnog anksioznog poremećaja.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
values ('GENERALNI_ANKSIOZNI_POREMECAJ', 'THIRD', 'TESKO', 38, 52, false, 'Dijagnostikovan je generalni anksiozni poremećaj.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
values ('GENERALNI_ANKSIOZNI_POREMECAJ', 'THIRD', 'DUBOKO', 53, 60, false, 'Dijagnostikovan je generalni anksiozni poremećaj.');

insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
values ('PANICNI_POREMECAJ', 'THIRD', 'BLAGO', 1, 13, true, 'Nemate naznake paničnog poremećaja.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
values ('PANICNI_POREMECAJ', 'THIRD', 'UMERENO', 14, 28, true, 'Nemate naznake paničnog poremećaja.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
values ('PANICNI_POREMECAJ', 'THIRD', 'IZRAZENO', 29, 37, true, 'Nemate naznake paničnog poremećaja.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
values ('PANICNI_POREMECAJ', 'THIRD', 'TESKO', 38, 52, false, 'Dijagnostikovan je panični poremećaj.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
values ('PANICNI_POREMECAJ', 'THIRD', 'DUBOKO', 53, 60, false, 'Dijagnostikovan je panični poremećaj.');

insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
values ('SOCIJALNA_FOBIJA', 'THIRD', 'BLAGO', 1, 11, true, 'Nemate naznake socijalne fobije.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
values ('SOCIJALNA_FOBIJA', 'THIRD', 'UMERENO', 12, 23, true, 'Nemate naznake socijalne fobije.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
values ('SOCIJALNA_FOBIJA', 'THIRD', 'IZRAZENO', 24, 31, true, 'Nemate naznake socijalne fobije.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
values ('SOCIJALNA_FOBIJA', 'THIRD', 'TESKO', 32, 44, false, 'Dijagnostikovana je socijalna fobija.');
insert into diagnostic_template(type, layer, intensity, min, max, final_result, text)
values ('SOCIJALNA_FOBIJA', 'THIRD', 'DUBOKO', 45, 50, false, 'Dijagnostikovana je socijalna fobija.');

-- anksioznost, prvi sloj
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Imam utisak da mogu da kontrolišem svoju brigu.', 0, 1, false, true);   -- 1
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Iako su određene situacije neprijatne, ja ih mogu podneti.', 0, 1, false, false);  -- 2
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('U određenim situacijama osećam tenziju.', 0, 1, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Ne predstavlja mi problem da se fokusiram na odredjene zadatke.', 0, 1, false, true);  -- 4
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Iako se ponekad ne osećam najbojle, nemam utisak da sam na „ivici pucanja“', 0, 1, false, false);  -- 5
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Kada razmišljam o budućnosti, ne brinem preterano.', 0, 1, false, false);   -- 6

-- anksioznost, drugi sloj
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Često razmišljam o budućnosti.', 1, 2, true, false); -- 7
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Kada razmišljam o budućnosti, ne vidim ništa dobro.', 1, 2, true, false); -- 8
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Plašim se budućnosti.', 1, 2, true, false);  -- 9
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Ne plašim se kako će moja budućnost izgledati.', 1, 2, false, false);  -- 10
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Voleo/-la bih da mogu da kontrolišem budućnost.', 1, 2, true, false); -- 11

insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Kada sam u grupi ljudi ponekad mislim da svi komentarišu mene.', 1, 2, true, false); --12
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Ne primećujem stvari koje drugi ljudi primećuju.', 1, 2, false, false); --13
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Retko šta mi promakne.', 1, 2, true, false); --14
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Često obraćam pažnju na stvari koje drugi ljudi smatraju beznačajnim.', 1, 2, true, false); --15
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Uvek sam na oprezu.', 1, 2, true, true); --16

insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Teško mi je da usmerim pažnju kada treba da odradim neki zadatak.', 1, 2, true, true); -- 17
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Misli mi često lutaju.', 1, 2, true, false);  -- 18
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Osećam preveliki pritisak kada izlazim na ispit/kada na poslu radim specifičan zadatak.', 1, 2, true, false); -- 19
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Osećam kao da me moje misli ometaju.', 1, 2, true, false); -- 20
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Teško mi je da pobegnem od svojih misli.', 1, 2, true, true);  -- 21


insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Često osećam napetost u mišićima.', 1, 2, true, false);  -- 22
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Osećam pritisak u grudima.', 1, 2, true, false);  -- 23
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Često mi srce lupa brzo.', 1, 2, true, false);  -- 24
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Kada se nađem u situaciji koja je neprijatna, nastojim da pobegnem po svaku cenu.', 1, 2, true, false); -- 25
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Nakon prisustva nekoj neprijatnoj situaciji, osećam kao da me celo telo boli.', 1, 2, true, true);  -- 26

insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Često sam napet/-a.', 1, 2, true, false);  -- 27
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Osećam kao da šta god uradim, nije dovoljno dobro.', 1, 2, true, true); -- 28
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Ponekad osećam da ne mogu ništa da uradim kako bih popraviao/-la neku situaciju.', 1, 2, true, true);  -- 29
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Ja sam osoba koja ne strepi.', 1, 2, false, false);  -- 30
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Često se osećam nesigurnim/nesigurnom.', 1, 2, true, false);  -- 31
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('U poslednje vreme mi je teško da se opustim.', 1, 2, true, true); -- 32

-- anksioznost, treci sloj
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Tokom prošlog meseca nisam konzumirao psihoaktivne supstance.', 2, 3, true, false);  -- 33
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('U poslednjih 6 meseci imam pojačanu anksioznist.', 2, 3, true, false);  -- 34
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('U poslednjih 6 meseci ne brinem povodom mnogih događaja i aktivnosti.', 2, 3, false, false);  -- 35
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('U poslednjih 6 meseci teško mi je da kontrolišem brigu.', 2, 3, true, false); -- 36
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('U poslednjih 6 meseci ne uspevam da „isključim mozak“.', 2, 3, true, false); -- 37
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('U poslednjih 6 meseci često osećam kao da sam „ma kraj živaca“.', 2, 3, true, false);  -- 38
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('U poslednjih 6 meseci često osećam da sam na „ivici pucanja“.', 2, 3, true, false);  -- 39
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('U poslednjih 6 meseci osećam snažnu mišićnu napetost.', 2, 3, true, false);  -- 40
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('U poslednjih 6 meseci se lako zamaram.', 2, 3, false, true); --41
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('U poslednjih 6 meseci imam poremećen san.', 2, 3, true, true);  --42
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('U poslednjih 6 meseci imam otežanu koncetraciju.', 2, 3, true, true);  -- 43
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('U poslednjih 6 meseci ne uspevam da rešim poslovne zadatke koje sam ranije uspevao/-la.', 2, 3, true, false);  -- 44


-- panicni napad, prvi sloj
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Tesko mi je da se nosim sa svojim telesnim simptomima.', 0, 4, true, false);  -- 45
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Ponekad se zadišem kada idem uz stpenice, ali to mi ne predstavlja problem.', 0, 4, false, false);   -- 46
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Ponekad imam utisak da ne mogu da kontrolišem svoje telo, ali mislima da je to normalno.', 0, 4, false, false);  -- 47
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Drugi ljudi mi kažu da se često žalim da mi nije dobro.', 0, 4, true, true); -- 48
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Uplašim se kada srce počne brzo da mi lupa.', 0, 4, true, false);  -- 49
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Kada zadrhtim u prisustvu drugih ljudi, plašim se da će oni pomisliti da sam lud.', 0, 4, true, false);  -- 50

-- panicni napad, drugi sloj
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Desilo mi se da verujem da ću umreti od srca/da doživljavam infarkt.', 1, 5, true, false); -- 51
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Imao/-la sam situaciju u kojoj sam verovao-la da mi mozak otkazuje.', 1, 5, true, false);  -- 52
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Ne mislim da ću poludeti.', 1, 5, false, false);   -- 53
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Desilo mi se da imam utisak/osećaj da u potpunosti gubim kontrolu nad svojim telom.', 1, 5, true, false);   -- 54
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Često imam osećaj vrtoglavice.', 1, 5, true, false);   -- 55
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Kada odlazim u bioskop najčešće biram mesto blizu vrata.', 1, 5, true, false);  --56
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Ponekad mislim da ću se onesvestiti.', 1, 5, true, false);  -- 57
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Desilo mi se da osećam trnce po koži.', 1, 5, true, false);  -- 58
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Ponekad se probudim noću zadihan/-a i u znoju.', 1, 5, true, false);  -- 59

-- panicni napad, treci sloj
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Više puta u životu mi se desilo da imam neprijatne telesne simptome praćene mislima da ću poludeti, umreti ili da ću se osramotiti pred drugim ljudima.', 2, 6, true, false);  -- 60
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Izbegavam šetnje po vrlo hladnom vremenu.', 2, 6, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Tokom prošlog meseca desio mi se 1 ili bar 1 panični napad.', 2, 6, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Ne patim od hroničnih bolesti.', 2, 6, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Tokom prošlog meseca desio mi se minimum 1 panični napad pri čemu sam brinuo o tome da li će biti sledećeg napada.', 2, 6, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Prelazak preko mosta mi je normalna stvar i normalno se osećam pri prelasku.', 2, 6, false, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Tokom prošlog meseca desio mi se bar 1 panični napad pri čemu sam značajno promenio svoje ponašanje, iščekujući novi napad.', 2, 6, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Tokom prošlog meseca nisam konzumirao psihoaktivne supstance.', 2, 6, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Prijaju mi šetnje po suncu.', 2, 6, false, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Izbegavam aktivnosti poput aerobika, plesa, sporta.', 2, 6, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Ukoliko se u društvu povede diskusija o nekoj temi koja mi je važna, nastojim da ne učstvujem kako se ne bih uznemirio/-la', 2, 6, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Izbegavam vožnju gradskim prevozom.', 2, 6, true, false);  -- 71

-- socijalna anksioznost, prvi sloj
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Ponekad mi je neprijatno u prisustvu drugih ljudi.', 0, 7, true, false);  -- 72
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Više volim da provodim vreme sam, nego sa drugima.', 0, 7, true, true);  -- 73
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Nemam problem da pitam nepoznatu osobu da mi pomogne u orijentaciji.', 0, 14, false, false); -- 74
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Družim se sa mnogo ljudi.', 0, 7, false, true); -- 75
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Prija mi prisustvo drugih ljudi.', 0, 7, false, true);  -- 76
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Ne volim da radim u velikim grupama.', 0, 7, true, false); -- 77

-- socijalna anksioznost, drugi sloj
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Kada treba da iznesem svoje mišljenje pred drugim ljudima (čak i bliskim) unervozim se, nije mi prijatno.', 1, 8, true, false);  -- 78
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Brine me šta će drugi ljudi misliti o meni.', 1, 8, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Obraćanje prodavcu u prodavnici za mene predstavlja izuzetan napor.', 1, 8, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Volim vožnju javnim prevozom.', 1, 8, false, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Razgovor sa nepoznatom osobom mi ne predstavlja stres.', 1, 8, false, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Kada prolazim kroz prostoriju punu ljudi najradije bih pobegao/-la.', 1, 8, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Često se plašim da ću se ponašati ili izgledati anksiozno.', 1, 8, true, false);  --84
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Kada neko gleda u mene, nastojim da što brže skrenem pogled', 1, 8, true, true);  --85 za sve vece od 84 dodaj 1

-- socijalna anksioznost, treci sloj

insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Mnoge svakodnevne situacije koje uključuju prisustvo drugih ljudi, za mene predstavljaju ogroman stres.', 2, 9, true, false);  -- 86
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Brinem da ću smoriti sagovornika.', 2, 9, true, true);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Pre javnog nastupa mislim da ću povratiti.', 2, 9, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Nikada ne jedem na javnom mestu.', 2, 9, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Tesko mi je da ostvarim kontakt sa osobom suprotnog pola.', 2, 9, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Kada se potpisujem pred drugima, često mi drhte ruke.', 2, 9, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Kada razgovaram sa šefom, glas mi se pretvori u pesak.', 2, 9, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Nemam problem da koristim javni toalet.', 2, 9, false, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Kontakt sa drugim ljudima mi predstavlja ogroman pritisak.', 2, 9, true, false);
insert into question(text, question_layer, detection_type_id, positive, depression_mark) values ('Gledam da po svaku cenu izbegnem sretanje drugih ljudi.', 2, 9, true, false);  -- 95


--- 96 - 218
------------------------------------------ SAD ------------------------------------------
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
    values (0, 10, true, 'Često se osetim otuđenim od drugih ljudi.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
    values (0, 10, true, 'Ponekad imam utisak da svi u mom životu su me napustili.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 10, false, 'Ja nisam žrtva okolnosti.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 10, true, 'U poslednje vreme se osećam ranljivo.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 10, true, 'Izgubila sam mnogo stvari u svom životu.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 10, true, 'Često osećam da ne mogu uticati na stvari.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 10, true, 'Stidim se svojih postupaka.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 10, true, 'Često osećam kao da me ništa ne ispunjava u potpunosti.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 10, true, 'Gotovo svi ljudi koji sam upoznao su bolji od mene.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 10, true, 'Ja sam crna ovca u svojoj porodici / društvu.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 10, true, 'Kajim se zbog nekih stvari koji sam uradio.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 10, true, 'Sramota me zbog dela koji sam učinio.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 10, true, 'U posljenje vreme se osećam usamljeno i napušteno.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 10, true, 'Tuga je ponekad toliko snažna da mislim da ne mogu da istežim.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 10, true, 'Žalim za mnogim stvarima koje sam bio nemoćan da uradim drugačije.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 10, true, 'Kada bih se vratio u prošlost pokušao bih da ispravim neke stvari.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 10, true, 'U poslednje vreme moje raspoloženje je na nuli.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 10, true, 'Razočaran sam u mnoge ljude u svom okruženju.', false);
------------------------------------------ DISGUSTED ------------------------------------------
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
    values (0, 11, false, 'Uglavnom brzo donesem odluke', false);--Često oklevam da donesem pravu odluku.
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 11, true, 'Plašim se mnogih stvari.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 11, true, 'Postoje ljudi pojave koji mi se gade.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 11, true, 'Kada vidim prosjaka na ulici uhvati me mučnine.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 11, true, 'Često imam potrebu da izteram pravdu do kraja.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 11, true, 'Zgržen sam mnogim pojavama u našem društvu.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 11, false, 'Uopšte ne osećam transfer blama.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 11, true, 'Nemam problem da osudim postupke drugih.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 11, true, 'Osećam odbojnost prema spoljašnjem svetu.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 11, true, 'Često osećam gađenje.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 11, true, 'Razočaran sam u druge.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 11, true, 'Ne slažem se sa mišljenjem druge.', false);
------------------------------------------ ANGRY ------------------------------------------
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 12, true, 'U prošlosti sam bio mnogo puta odbačen.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 12, true, 'Imam potrebu da preispitujem pojave u svojem okruženju.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 12, false, 'Retko kad se osećam odsutno.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 12, true, 'U situjacijama koje su neprijatne ja se najčešće povučem.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 12, true, 'Iritira me prisustvo drugih ljudi.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 12, true, 'I najmanja sitnica može da me razbesni.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 12, true, 'U koliko ti druga osoba dozvoli, treba da iskoristiš.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 12, true, 'Drugi ljudi me često provociraju.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 12, true, 'U koliko bi moj partner popio piće sa kolegom sa posla osećao bih ljutnju.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 12, true, 'Ponekad ne mogu da kontrolišem nalet besa.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 12, false, 'Nemam utisak da su mi narušena osnovna ljudska prava.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 12, true, 'Drugi ljudi su nepravedni prema meni.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 12, true, 'U prošlosti sam bio žrtva tuđih podsmeha.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 12, false, 'Ljude me uglavnom ispoštuju.', false);--Ne pamtim kada sam poslednji put bio ispoštovan.
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 12, true, 'Kada se dogovorim za kafu sa nekim često se desi da se neko ne pojavi.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 12, true, 'Mnogi ljudi su me tokom života izdali.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 12, true, 'Smatram da mogu da nađem prednosti i mane u svakoj situaciji.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 12, true, 'Ponekad imam utisak da se stvari dešavaju dok ja nisam prisutan.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 12, true, 'Trudim se da održim pozitivno raspoloženje ali uprkos tome mnogo toga me iznervira.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 12, true, 'Ponekad sam imao fizičke obračune sa drugim ljudima.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 12, true, 'Bes koji osećam teško kontrolisati.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 12, false, 'Smatram da vredi živeti u ovom svetu.', false);--Smatram da ne vredi živeti u ovom svetu iz opačenih vrednosti.
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 12, true, 'U prošlosti se dešavalo da me drugi ljudi doživljavaju kao „dvorsku ludu“.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 12, true, 'Kada vratim film unazad više puta sam bio ostavljen/napušten nego ispoštovan.', false);
------------------------------------------ FEARFUL ------------------------------------------
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 13, true, 'Kada sam sa društvom osećam se kao da svi gledaju u mene.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 13, true, 'Ponekad je dovoljna sitnica da se uznemirim.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 13, true, 'Smatram da nisam uspeo da ostvarim neke stvari jer su ljudi imali predrasude prema meni.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 13, true, 'Često sam bio isključen iz grupa čiji član sam želeo da budem.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 13, true, 'Nikome nije stalo do mene.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 13, false, 'Lako mi je da pronađem sopstvane vrednosti.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 13, true, 'Drugi ljudi su mnogo bolji od mene.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 13, true, 'Šta god sam do sada započeo nikako nisam mogao da budem dovoljno dobar u tome.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 13, true, 'Ponekad osećam kao da nosim ogroman teret na svojim leđima.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 13, true, 'Moji misli su ponekad toliko brze da se zbunim.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 13, true, 'Plašim se više nego drugi ljudi.', false);--
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 13, false, 'Ukoliko bih tražio pomoć od drugih ljudi verujem da bih je dobio.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 13, true, 'Pretnja drugih ljudi nije mi nepoznato.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 13, true, 'Osećam da sam u više situacija bio odbačen nego prihvaćen.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 13, true, 'Ponekad mislim da nisam dovoljno jak da se nosim sa svim problemima.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 13, true, 'Trudim se da ohrabrujem sam sebe ali ponekad mi to teško ide.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 13, true, 'Mnogo vremena provodim razmišljajući o tome šta bi moglo da uđe po zlu.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 13, true, 'Ponekad mi prijatelji kažu da ne treba da se plašim toliko stvari.', false);
------------------------------------------ BAD ------------------------------------------
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 14, true, 'Često mi je svejedno kako ću provesti dan.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 14, true, 'Izgubio sam interesovanje za mnoge stvari.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 14, true, 'Ponekad osećam kao da ne uspevam da ispunim sve obaveze.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 14, true, 'Često sam u žurbi.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 14, true, 'Primećujem dosta stvari koji me uznemiruju.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 14, true, 'Volela bih da mogu da kontrolišem sve.', false); -- jel ovo negativan?
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 14, false, 'U poslednje vreme ne spavam više nego inače.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 14, true, 'Primećujem da moja koncentracija lošija/slabija nego pre.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 14, false, 'Lako mi je da pronađem nešto sto će mi okupirati pažnju.', false);--U poslednje mi teško da pronađem nešto sto će mi okupirati pažnju.
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 14, true, 'Većinu vremena sam zauzet.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 14, true, 'Često osećam kao da ne uspevam da se odmorim ni nakon dovoljno sati sna.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 14, true, 'Umoran sam.', false);
------------------------------------------ SURPRISED ------------------------------------------
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 15, true, 'Mnogi stvari me šokiraju.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 15, true, 'Neprijatno sam iznenađen stvarima iz svog okruženja.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 15, true, 'Ponekad mi deluje da ništa nije dovoljno dobro.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 15, true, 'Zbunjuje me način na koju funkcionišu ljudi oko mene.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 15, true, 'Često se pozitivno iznenadim.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 15, true, 'Ostanem u čudu kada vidim šta je neko uspeo da postigne.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 15, false, 'Uglavnom nema ništa bih jako želeo da postignem.', false);--Postoje stvari koje bih jako želeo da postignem.
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 15, false, 'Retko kad osećam da imam mnogo energije.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 15, true, 'Zaprepašćen sam načinom na koje funkcioniše društvo.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 15, true, 'Često se osećam zbunjeno.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 15, true, 'Divim se ljudima iz svoje okoline.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 15, true, 'Uzbuđen sam povodom stvari koje me čekaju u budućnosti.', false);
------------------------------------------ HAPPY ------------------------------------------
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, true, 'U toku dana osećam nalete pozitivne energije.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, true, 'Jedno od vrednosti koje se držim je nada.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, false, 'Ne osećam potrebu da budem blizak sa drugom osobom.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, true, 'Tuđa osećanja mi znače.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, true, 'Često se osećam zahvalnost prema stvarima koji su mi se desile.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, true, 'Smatram da su drugi ljudi vredni/ljubavi.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, true, 'Drugi ljudi mi često kažu da sam kreativna osoba.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, true, 'Često imam potrebu da istupim za ljude koje nemaju snagu da se bore sami.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, true, 'Smatram da je svako ljudsko biće vredno sama po sebi.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, false, 'Tokom odrastanja nisam osetio da me drugi poštuju.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, true, 'Verujem u svoje sposobnosti.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, false, 'Nisam zadovoljan sa svojim postignućima.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, true, 'Imam želju da se interesujem za stvari koje nisu moja struka.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, true, 'Voleo bih da tokom svog života saznam što više stvari.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, true, 'Mogu da pronađem sreću u skoro svemu.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, true, 'Često se osećam kao da ništa me ne sprečava.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, true, 'Kada neko u društvu baci foru na moj račun ja se ne ljutim.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (0, 16, true, 'Prija mi kada se nešto dešava oko mene.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 16, true, 'Često verujem da će se u budućnosti dogoditi dobre stvari.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 16, true, 'Meni se može verovati.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 16, true, 'Smatram da mir ima cenu.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 16, false, 'Retko kad osećam toliko snagu da započnem nove stvari.', false); --
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 16, true, 'Osećam se prihvaćeno.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 16, false, 'Do sada nisam postigao sve što sam želeo.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 16, true, 'Uvek pronađem nešto što me zaokupira.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 16, true, 'Generalno sam zadovoljan sa životom.', false);
insert into question(question_layer, detection_type_id, positive, text, depression_mark)
values (1, 16, true, 'Prija mi okruženje u kom se stalno nešto dešava.', false);

--- users ---
insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)values
    (2, 'Milica', 'Petrovic', 'mpetrovic764307@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 2000, 0, 'student');

insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)
values (2, 'Jovan', 'Jovanović', 'jovan@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 2000, 1, 'student');

insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)
values (1, 'Tamara', 'Konjevic', 'tamara@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 1999, 0, 'psiholog');

insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)
values (1, 'Milica', 'Okiljevic', 'milica@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 1980, 0, 'psiholog');
insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)
values (1, 'Zorica', 'Lukic', 'zorica@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 1964, 0, 'psiholog');
insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)
values (1, 'Lazar', 'Lazarevic', 'lazar@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 1976, 1, 'psiholog');
insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)
values (1, 'Milos', 'Milosevic', 'milos@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 2000, 1, 'psiholog');

insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)values
    (2, 'Pera', 'Peric', 'pera@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 1996, 1, 'student');
insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)values
    (2, 'Maša', 'Mašić', 'masa@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 2001, 0, 'pravnik');
insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)values
    (2, 'Ivana', 'Ivanic', 'ivana@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 1999, 0, 'tehnolog');


insert into result(user_id, detected, time, intensity) values (2, 'SAD', '2023-05-18 18:57:58.508-07', 2); -- 3

insert into answer(user_id, question_id, score, time) values (2, 96, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 97, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 98, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 99, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 100, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 101, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 102, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 103, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 104, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 105, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 106, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 107, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 108, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 109, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 110, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 111, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 112, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 113, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 114, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 115, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 116, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 117, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 118, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 119, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 120, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 121, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 122, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 123, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 124, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 125, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 126, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 127, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 128, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 129, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 130, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 131, 4, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 132, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 133, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 134, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 135, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 136, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 137, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 138, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 139, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 140, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 141, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 142, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 143, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 144, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 145, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 146, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 147, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 148, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 149, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 150, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 151, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 152, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 153, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 154, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 155, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 156, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 157, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 158, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 159, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 160, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 161, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 162, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 163, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 164, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 165, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 166, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 167, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 168, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 169, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 170, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 171, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 172, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 173, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 174, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 175, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 176, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 177, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 178, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 179, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 180, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 181, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 182, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 183, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 184, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 185, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 186, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 187, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 188, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 189, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 190, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 191, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 192, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 193, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 194, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 195, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 196, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 197, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 198, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 199, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 200, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 201, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 202, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 203, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 204, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 205, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 206, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 207, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 208, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 209, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 210, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 211, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 212, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 213, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 214, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 215, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 216, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 217, 1, '2023-05-18 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (2, 218, 1, '2023-05-18 18:57:58.508-07');


insert into user_psychologist(user_id, psychologist_id) values (1, 3);
insert into user_psychologist(user_id, psychologist_id) values (2, 3);
insert into user_psychologist(user_id, psychologist_id) values (8, 3);
insert into user_psychologist(user_id, psychologist_id) values (9, 3);
insert into user_psychologist(user_id, psychologist_id) values (10, 3);


-- insert into result(user_id, detected, time) values (1, 'USLOVI_ZA_ANKSIOZNOST', '2023-05-20 18:57:58.508-07' );  --10
-- insert into result(user_id, detected, time) values (1, 'USLOVI_ZA_PANICNI_NAPAD', '2023-05-21 18:57:58.508-07' );  -- 12
insert into result(user_id, detected, time,  intensity) values (1, 'USLOVI_ZA_SOCIJALNU_ANKSIOZNOST', '2023-05-24 18:57:58.508-07', 4);  -- 14
insert into result(user_id, detected, time,  intensity) values (1, 'SOCIJALNA_ANKSIOZNOST', '2023-05-24 18:57:58.508-07', 3);   -- 2
insert into result(user_id, detected, time,  intensity) values (1, 'SOCIJALNA_FOBIJA', '2023-05-24 18:57:58.508-07', 2);  -- 15

-- insert into answer(user_id, question_id, score, time) values (1, 1, 3, '2023-05-20 18:57:58.508-07');
-- insert into answer(user_id, question_id, score, time) values (1, 2, 4, '2023-05-20 18:57:58.508-07');
-- insert into answer(user_id, question_id, score, time) values (1, 3, 2, '2023-05-20 18:57:58.508-07');
-- insert into answer(user_id, question_id, score, time) values (1, 4, 5, '2023-05-20 18:57:58.508-07');
-- insert into answer(user_id, question_id, score, time) values (1, 5, 1, '2023-05-20 18:57:58.508-07');
-- insert into answer(user_id, question_id, score, time) values (1, 6, 3, '2023-05-20 18:57:58.508-07');


-- insert into answer(user_id, question_id, score, time) values (1, 45, 3, '2023-05-21 18:57:58.508-07');
-- insert into answer(user_id, question_id, score, time) values (1, 46, 4, '2023-05-21 18:57:58.508-07');
-- insert into answer(user_id, question_id, score, time) values (1, 47, 2, '2023-05-21 18:57:58.508-07');
-- insert into answer(user_id, question_id, score, time) values (1, 48, 5, '2023-05-21 18:57:58.508-07');
-- insert into answer(user_id, question_id, score, time) values (1, 49, 1, '2023-05-21 18:57:58.508-07');
-- insert into answer(user_id, question_id, score, time) values (1, 50, 3, '2023-05-21 18:57:58.508-07');
--
insert into answer(user_id, question_id, score, time) values (1, 72, 4, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 73, 5, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 74, 1, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 75, 2, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 76, 1, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 77, 5, '2023-05-24 18:57:58.508-07');

insert into answer(user_id, question_id, score, time) values (1, 78, 5, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 79, 5, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 80, 5, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 81, 2, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 82, 2, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 83, 4, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 84, 4, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 85, 4, '2023-05-24 18:57:58.508-07');

insert into answer(user_id, question_id, score, time) values (1, 86, 5, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 87, 5, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 88, 4, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 89, 5, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 90, 4, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 91, 5, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 92, 1, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 93, 4, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 94, 5, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 95, 5, '2023-05-24 18:57:58.508-07');


-- dodati uslovi za cos ank za ivana za datume
insert into result(user_id, detected, time, intensity) values (8, 'USLOVI_ZA_ANKSIOZNOST', '2023-05-20 18:57:58.508-07', 0);

insert into answer(user_id, question_id, score, time) values (8, 1, 3, '2023-05-20 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 2, 4, '2023-05-20 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 3, 2, '2023-05-20 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 4, 5, '2023-05-20 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 5, 1, '2023-05-20 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 6, 3, '2023-05-20 18:57:58.508-07');

insert into result(user_id, detected, time, intensity) values (8, 'USLOVI_ZA_ANKSIOZNOST', '2023-05-21 18:57:58.508-07', 1);

insert into answer(user_id, question_id, score, time) values (8, 1, 3, '2023-05-21 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 2, 4, '2023-05-21 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 3, 2, '2023-05-21 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 4, 5, '2023-05-21 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 5, 1, '2023-05-21 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 6, 3, '2023-05-21 18:57:58.508-07');

insert into result(user_id, detected, time, intensity) values (8, 'USLOVI_ZA_ANKSIOZNOST', '2023-05-24 18:57:58.508-07', 2);

insert into answer(user_id, question_id, score, time) values (8, 1, 3, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 2, 4, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 3, 2, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 4, 5, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 5, 1, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 6, 3, '2023-05-24 18:57:58.508-07');


-- podaci za izveštaje
insert into result(user_id, detected, time, intensity) values (2, 'USLOVI_ZA_PANICNI_NAPAD', '2023-06-14 10:00:58.508-07', 2);
insert into result(user_id, detected, time, intensity) values (2, 'USLOVI_ZA_SOCIJALNU_ANKSIOZNOST', '2023-06-14 10:00:58.508-07', 2);


insert into result(user_id, detected, time, intensity) values (2, 'USLOVI_ZA_PANICNI_NAPAD', '2023-06-28 13:00:58.508-07', 4);
insert into result(user_id, detected, time, intensity) values (2, 'PANICNI_NAPAD', '2023-06-28 13:00:58.508-07', 3);

insert into result(user_id, detected, time, intensity) values (8, 'USLOVI_ZA_PANICNI_NAPAD', '2023-06-16 14:30:58.508-07', 1);
insert into result(user_id, detected, time, intensity) values (8, 'USLOVI_ZA_ANKSIOZNOST', '2023-06-16 13:30:58.508-07', 3);
insert into result(user_id, detected, time, intensity) values (8, 'USLOVI_ZA_SOCIJALNU_ANKSIOZNOST', '2023-06-16 13:30:58.508-07', 3);

insert into result(user_id, detected, time, intensity) values (9, 'USLOVI_ZA_ANKSIOZNOST', '2023-06-16 13:30:58.508-07', 4);
insert into result(user_id, detected, time, intensity) values (9, 'ANKSIOZNOST', '2023-06-16 13:30:58.508-07', 3);
insert into result(user_id, detected, time, intensity) values (9, 'GENERALNI_ANKSIOZNI_POREMECAJ', '2023-06-16 14:30:58.508-07', 1);

insert into result(user_id, detected, time, intensity) values (10, 'USLOVI_ZA_ANKSIOZNOST', '2023-06-16 19:30:58.508-07', 1);
insert into result(user_id, detected, time, intensity) values (10, 'ANKSIOZNOST', '2023-06-16 19:30:58.508-07', 2);
insert into result(user_id, detected, time, intensity) values (10, 'GENERALNI_ANKSIOZNI_POREMECAJ', '2023-06-16 19:30:58.508-07', 1);

insert into result(user_id, detected, time, intensity) values (10, 'USLOVI_ZA_PANICNI_NAPAD', '2023-07-16 19:30:58.508-07', 2);
insert into result(user_id, detected, time, intensity) values (10, 'USLOVI_ZA_SOCIJALNU_ANKSIOZNOST', '2023-07-16 19:30:58.508-07', 2);

insert into result(user_id, detected, time, intensity) values (2, 'USLOVI_ZA_PANICNI_NAPAD', '2023-06-14 10:00:58.508-07', 2);
insert into result(user_id, detected, time, intensity) values (2, 'USLOVI_ZA_SOCIJALNU_ANKSIOZNOST', '2023-06-14 10:00:58.508-07', 0);


insert into result(user_id, detected, time,  intensity) values (1, 'USLOVI_ZA_SOCIJALNU_ANKSIOZNOST', '2023-08-02 18:57:58.508-07', 4);
insert into result(user_id, detected, time,  intensity) values (1, 'SOCIJALNA_ANKSIOZNOST', '2023-08-02 18:57:58.508-07', 3);
insert into result(user_id, detected, time,  intensity) values (1, 'SOCIJALNA_FOBIJA', '2023-08-02 18:57:58.508-07', 2);

