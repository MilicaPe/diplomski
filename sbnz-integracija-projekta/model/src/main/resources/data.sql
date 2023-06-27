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

insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)values
    (2, 'Milica', 'Petrovic', 'mpetrovic764307@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 2000, 0, 'student');

-- anksioznost, prvi sloj
insert into question(text, question_layer, detection_type, positive) values ('Imam utisak da mogu da kontrolišem svoju brigu.', 0, 0, false);   -- 1
insert into question(text, question_layer, detection_type, positive) values ('Iako su određene situacije neprijatne, ja ih mogu podneti.', 0, 0, false);  -- 2
insert into question(text, question_layer, detection_type, positive) values ('U određenim situacijama osećam tenziju.', 0, 0, true);
insert into question(text, question_layer, detection_type, positive) values ('Ne predstavlja mi problem da se fokusiram na odredjene zadatke.', 0, 0, false);  -- 4
insert into question(text, question_layer, detection_type, positive) values ('Iako se ponekad ne osećam najbojle, nemam utisak da sam na „ivici pucanja“', 0, 0, false);  -- 5
insert into question(text, question_layer, detection_type, positive) values ('Kada razmišljam o budućnosti, ne brinem preterano.', 0, 0, false);   -- 6

-- anksioznost, drugi sloj
insert into question(text, question_layer, detection_type, positive) values ('Često razmišljam o budućnosti.', 1, 0, true); -- 7
insert into question(text, question_layer, detection_type, positive) values ('Kada razmišljam o budućnosti, ne vidim ništa dobro.', 1, 0, true); -- 8
insert into question(text, question_layer, detection_type, positive) values ('Plašim se budućnosti.', 1, 0, true);  -- 9
insert into question(text, question_layer, detection_type, positive) values ('Ne plašim se kako će moja budućnost izgledati.', 1, 0, false);  -- 10
insert into question(text, question_layer, detection_type, positive) values ('Voleo/-la bih da mogu da kontrolišem budućnost.', 1, 0, true); -- 11

insert into question(text, question_layer, detection_type, positive) values ('Kada sam u grupi ljudi ponekad mislim da svi komentarišu mene.', 1, 0, true); --12
insert into question(text, question_layer, detection_type, positive) values ('Ne primećujem stvari koje drugi ljudi primećuju.', 1, 0, false); --13
insert into question(text, question_layer, detection_type, positive) values ('Retko šta mi promakne.', 1, 0, true); --14
insert into question(text, question_layer, detection_type, positive) values ('Često obraćam pažnju na stvari koje drugi ljudi smatraju beznačajnim.', 1, 0, true); --15
insert into question(text, question_layer, detection_type, positive) values ('Uvek sam na oprezu.', 1, 0, true); --16

insert into question(text, question_layer, detection_type, positive) values ('Teško mi je da usmerim pažnju kada treba da odradim neki zadatak.', 1, 0, true); -- 17
insert into question(text, question_layer, detection_type, positive) values ('Misli mi često lutaju.', 1, 0, true);  -- 18
insert into question(text, question_layer, detection_type, positive) values ('Osećam preveliki pritisak kada izlazim na ispit/kada na poslu radim specifičan zadatak.', 1, 0, true); -- 19
insert into question(text, question_layer, detection_type, positive) values ('Osećam kao da me moje misli ometaju.', 1, 0, true); -- 20
insert into question(text, question_layer, detection_type, positive) values ('Teško mi je da pobegnem od svojih misli.', 1, 0, true);  -- 21


insert into question(text, question_layer, detection_type, positive) values ('Često osećam napetost u mišićima.', 1, 0, true);  -- 22
insert into question(text, question_layer, detection_type, positive) values ('Osećam pritisak u grudima.', 1, 0, true);  -- 23
insert into question(text, question_layer, detection_type, positive) values ('Često mi srce lupa brzo.', 1, 0, true);  -- 24
insert into question(text, question_layer, detection_type, positive) values ('Kada se nađem u situaciji koja je neprijatna, nastojim da pobegnem po svaku cenu.', 1, 0, true); -- 25
insert into question(text, question_layer, detection_type, positive) values ('Nakon prisustva nekoj neprijatnoj situaciji, osećam kao da me celo telo boli.', 1, 0, true);  -- 26

insert into question(text, question_layer, detection_type, positive) values ('Često sam napet/-a.', 1, 0, true);  -- 27
insert into question(text, question_layer, detection_type, positive) values ('Osećam kao da šta god uradim, nije dovoljno dobro.', 1, 0, true); -- 28
insert into question(text, question_layer, detection_type, positive) values ('Ponekad osećam da ne mogu ništa da uradim kako bih popraviao/-la neku situaciju.', 1, 0, true);  -- 29
insert into question(text, question_layer, detection_type, positive) values ('Ja sam osoba koja ne strepi.', 1, 0, false);  -- 30
insert into question(text, question_layer, detection_type, positive) values ('Često se osećam nesigurnim/nesigurnom.', 1, 0, true);  -- 31
insert into question(text, question_layer, detection_type, positive) values ('U poslednje vreme mi je teško da se opustim.', 1, 0, true); -- 32

-- anksioznost, treci sloj
insert into question(text, question_layer, detection_type, positive) values ('Tokom prošlog meseca nisam konzumirao psihoaktivne supstance.', 2, 0, true);  -- 33
insert into question(text, question_layer, detection_type, positive) values ('U poslednjih 6 meseci imam pojačanu anksioznist.', 2, 0, true);  -- 34
insert into question(text, question_layer, detection_type, positive) values ('U poslednjih 6 meseci ne brinem povodom mnogih događaja i aktivnosti.', 2, 0, false);  -- 35
insert into question(text, question_layer, detection_type, positive) values ('U poslednjih 6 meseci teško mi je da kontrolišem brigu.', 2, 0, true); -- 36
insert into question(text, question_layer, detection_type, positive) values ('U poslednjih 6 meseci ne uspevam da „isključim mozak“.', 2, 0, true); -- 37
insert into question(text, question_layer, detection_type, positive) values ('U poslednjih 6 meseci često osećam kao da sam „ma kraj živaca“.', 2, 0, true);  -- 38
insert into question(text, question_layer, detection_type, positive) values ('U poslednjih 6 meseci često osećam da sam na „ivici pucanja“.', 2, 0, true);  -- 39
insert into question(text, question_layer, detection_type, positive) values ('U poslednjih 6 meseci osećam snažnu mišićnu napetost.', 2, 0, true);  -- 40
insert into question(text, question_layer, detection_type, positive) values ('U poslednjih 6 meseci se lako zamaram normalno.', 2, 0, false); --41
insert into question(text, question_layer, detection_type, positive) values ('U poslednjih 6 meseci imam poremećen san.', 2, 0, true);  --42
insert into question(text, question_layer, detection_type, positive) values ('U poslednjih 6 meseci imam otežanu koncetraciju.', 2, 0, true);  -- 43
insert into question(text, question_layer, detection_type, positive) values ('U poslednjih 6 meseci ne uspevam da rešim poslovne zadatke koje sam ranije uspevao/-la.', 2, 0, true);  -- 44


-- panicni napad, prvi sloj
insert into question(text, question_layer, detection_type, positive) values ('Tesko mi je da se nosim sa svojim telesnim simptomima.', 0, 1, true);  -- 45
insert into question(text, question_layer, detection_type, positive) values ('Ponekad se zadišem kada idem uz stpenice, ali to mi ne predstavlja problem.', 0, 1, false);   -- 46
insert into question(text, question_layer, detection_type, positive) values ('Ponekad imam utisak da ne mogu da kontrolišem svoje telo, ali mislima da je to normalno.', 0, 1, false);  -- 47
insert into question(text, question_layer, detection_type, positive) values ('Drugi ljudi mi kažu da se često žalim da mi nije dobro.', 0, 1, true); -- 48
insert into question(text, question_layer, detection_type, positive) values ('Uplašim se kada srce počne brzo da mi lupa.', 0, 1, true);  -- 49
insert into question(text, question_layer, detection_type, positive) values ('Kada zadrhtim u prisustvu drugih ljudi, plašim se da će oni pomisliti da sam lud.', 0, 1, true);  -- 50

-- panicni napad, drugi sloj
insert into question(text, question_layer, detection_type, positive) values ('Desilo mi se da verujem da ću umreti od srca/da doživljavam infarkt.', 1, 1, true); -- 51
insert into question(text, question_layer, detection_type, positive) values ('Imao/-la sam situaciju u kojoj sam verovao-la da mi mozak otkazuje.', 1, 1, true);  -- 52
insert into question(text, question_layer, detection_type, positive) values ('Ne mislim da ću poludeti.', 1, 1, false);   -- 53
insert into question(text, question_layer, detection_type, positive) values ('Desilo mi se da imam utisak/osećaj da u potpunosti gubim kontrolu nad svojim telom.', 1, 1, true);   -- 54
insert into question(text, question_layer, detection_type, positive) values ('Često imam osećaj vrtoglavice.', 1, 1, true);   -- 55
insert into question(text, question_layer, detection_type, positive) values ('Kada odlazim u bioskop najčešće biram mesto blizu vrata.', 1, 1, true);  --56
insert into question(text, question_layer, detection_type, positive) values ('Ponekad mislim da ću se onesvestiti.', 1, 1, true);  -- 57
insert into question(text, question_layer, detection_type, positive) values ('Desilo mi se da osećam trnce po koži.', 1, 1, true);  -- 58
insert into question(text, question_layer, detection_type, positive) values ('Ponekad se probudim noću zadihan/-a i u znoju.', 1, 1, true);  -- 59

-- panicni napad, treci sloj
insert into question(text, question_layer, detection_type, positive) values ('Više puta u životu mi se desilo da imam neprijatne telesne simptome praćene mislima da ću poludeti, umreti ili da ću se osramotiti pred drugim ljudima.', 2, 1, true);  -- 60
insert into question(text, question_layer, detection_type, positive) values ('Izbegavam šetnje po vrlo hladnom vremenu.', 2, 1, true);
insert into question(text, question_layer, detection_type, positive) values ('Tokom prošlog meseca desio mi se 1 ili bar 1 panični napad.', 2, 1, true);
insert into question(text, question_layer, detection_type, positive) values ('Ne patim od hroničnih bolesti.', 2, 1, true);
insert into question(text, question_layer, detection_type, positive) values ('Tokom prošlog meseca desio mi se minimum 1 panični napad pri čemu sam brinuo o tome da li će biti sledećeg napada.', 2, 1, true);
insert into question(text, question_layer, detection_type, positive) values ('Prelazak preko mosta mi je normalna stvar i normalno se osećam pri prelasku.', 2, 1, false);
insert into question(text, question_layer, detection_type, positive) values ('Tokom prošlog meseca desio mi se bar 1 panični napad pri čemu sam značajno promenio svoje ponašanje, iščekujući novi napad.', 2, 1, true);
insert into question(text, question_layer, detection_type, positive) values ('Tokom prošlog meseca nisam konzumirao psihoaktivne supstance.', 2, 1, true);
insert into question(text, question_layer, detection_type, positive) values ('Prijaju mi šetnje po suncu.', 2, 1, false);
insert into question(text, question_layer, detection_type, positive) values ('Izbegavam aktivnosti poput aerobika, plesa, sporta.', 2, 1, true);
insert into question(text, question_layer, detection_type, positive) values ('Ukoliko se u društvu povede diskusija o nekoj temi koja mi je važna, nastojim da ne učstvujem kako se ne bih uznemirio/-la', 2, 1, true);
insert into question(text, question_layer, detection_type, positive) values ('Izbegavam vožnju gradskim prevozom.', 2, 1, true);  -- 71

-- socijalna anksioznost, prvi sloj
insert into question(text, question_layer, detection_type, positive) values ('Ponekad mi je neprijatno u prisustvu drugih ljudi.', 0, 2, true);  -- 72
insert into question(text, question_layer, detection_type, positive) values ('Više volim da provodim vreme sam, nego sa drugima.', 0, 2, true);  -- 73
insert into question(text, question_layer, detection_type, positive) values ('Nemam problem da pitam nepoznatu osobu da mi pomogne u orijentaciji.', 0, 2, false); -- 74
insert into question(text, question_layer, detection_type, positive) values ('Družim se sa mnogo ljudi.', 0, 2, false); -- 75
insert into question(text, question_layer, detection_type, positive) values ('Prija mi prisustvo drugih ljudi.', 0, 2, false);  -- 76
insert into question(text, question_layer, detection_type, positive) values ('Ne volim da radim u velikim grupama.', 0, 2, true); -- 77

-- socijalna anksioznost, drugi sloj
insert into question(text, question_layer, detection_type, positive) values ('Kada treba da iznesem svoje mišljenje pred drugim ljudima (čak i bliskim) unervozim se, nije mi prijatno.', 1, 2, true);  -- 78
insert into question(text, question_layer, detection_type, positive) values ('Brine me šta će drugi ljudi misliti o meni.', 1, 2, true);
insert into question(text, question_layer, detection_type, positive) values ('Obraćanje prodavcu u prodavnici za mene predstavlja izuzetan napor.', 1, 2, true);
insert into question(text, question_layer, detection_type, positive) values ('Volim vožnju javnim prevozom.', 1, 2, false);
insert into question(text, question_layer, detection_type, positive) values ('Razgovor sa nepoznatom osobom mi ne predstavlja stres.', 1, 2, false);
insert into question(text, question_layer, detection_type, positive) values ('Kada prolazim kroz prostoriju punu ljudi najradije bih pobegao/-la.', 1, 2, true);
insert into question(text, question_layer, detection_type, positive) values ('Često se plašim da ću se ponašati ili izgledati anksiozno.', 1, 2, true);  --84

-- socijalna anksioznost, treci sloj

insert into question(text, question_layer, detection_type, positive) values ('Mnoge svakodnevne situacije koje uključuju prisustvo drugih ljudi, za mene predstavljaju ogroman stres.', 2, 2, true);  -- 85
insert into question(text, question_layer, detection_type, positive) values ('Brinem da ću smoriti sagovornika.', 2, 2, true);
insert into question(text, question_layer, detection_type, positive) values ('Pre javnog nastupa mislim da ću povratiti.', 2, 2, true);
insert into question(text, question_layer, detection_type, positive) values ('Nikada ne jedem na javnom mestu.', 2, 2, true);
insert into question(text, question_layer, detection_type, positive) values ('Tesko mi je da ostvarim kontakt sa osobom suprotnog pola.', 2, 2, true);
insert into question(text, question_layer, detection_type, positive) values ('Kada se potpisujem pred drugima, često mi drhte ruke.', 2, 2, true);
insert into question(text, question_layer, detection_type, positive) values ('Kada razgovaram sa šefom, glas mi se pretvori u pesak.', 2, 2, true);
insert into question(text, question_layer, detection_type, positive) values ('Nemam problem da koristim javni toalet.', 2, 2, false);
insert into question(text, question_layer, detection_type, positive) values ('Kontakt sa drugim ljudima mi predstavlja ogroman pritisak.', 2, 2, true);
insert into question(text, question_layer, detection_type, positive) values ('Gledam da po svaku cenu izbegnem sretanje drugih ljudi.', 2, 2, true);  -- 94


--- 95 - 217
------------------------------------------ SAD ------------------------------------------
insert into question(question_layer, detection_type, positive, text)
    values (0, 3, true, 'Često se osetim otuđenim od drugih ljudi.');
insert into question(question_layer, detection_type, positive, text)
    values (0, 3, true, 'Ponekad imam utisak da svi u mom životu su me napustili.');
insert into question(question_layer, detection_type, positive, text)
values (0, 3, false, 'Ja nisam žrtva okolnosti.');
insert into question(question_layer, detection_type, positive, text)
values (0, 3, true, 'U poslednje vreme se osećam ranljivo.');
insert into question(question_layer, detection_type, positive, text)
values (0, 3, true, 'Izgubila sam mnogo stvari u svom životu.');
insert into question(question_layer, detection_type, positive, text)
values (0, 3, true, 'Često osećam da ne mogu uticati na stvari.');
insert into question(question_layer, detection_type, positive, text)
values (0, 3, true, 'Stidim se svojih postupaka.');
insert into question(question_layer, detection_type, positive, text)
values (0, 3, true, 'Često osećam kao da me ništa ne ispunjava u potpunosti.');
insert into question(question_layer, detection_type, positive, text)
values (0, 3, true, 'Gotovo svi ljudi koji sam upoznao su bolji od mene.');
insert into question(question_layer, detection_type, positive, text)
values (0, 3, true, 'Ja sam crna ovca u svojoj porodici / društvu.');
insert into question(question_layer, detection_type, positive, text)
values (0, 3, true, 'Kajim se zbog nekih stvari koji sam uradio.');
insert into question(question_layer, detection_type, positive, text)
values (0, 3, true, 'Sramota me zbog dela koji sam učinio.');
insert into question(question_layer, detection_type, positive, text)
values (1, 3, true, 'U posljenje vreme se osećam usamljeno i napušteno.');
insert into question(question_layer, detection_type, positive, text)
values (1, 3, true, 'Tuga je ponekad toliko snažna da mislim da ne mogu da istežim.');
insert into question(question_layer, detection_type, positive, text)
values (1, 3, true, 'Žalim za mnogim stvarima koje sam bio nemoćan da uradim drugačije.');
insert into question(question_layer, detection_type, positive, text)
values (1, 3, true, 'Kada bih se vratio u prošlost pokušao bih da ispravim neke stvari.');
insert into question(question_layer, detection_type, positive, text)
values (1, 3, true, 'U poslednje vreme moje raspoloženje je na nuli.');
insert into question(question_layer, detection_type, positive, text)
values (1, 3, true, 'Razočaran sam u mnoge ljude u svom okruženju.');
------------------------------------------ DISGUSTED ------------------------------------------
insert into question(question_layer, detection_type, positive, text)
    values (0, 4, false, 'Uglavnom brzo donesem odluke');--Često oklevam da donesem pravu odluku.
insert into question(question_layer, detection_type, positive, text)
values (0, 4, true, 'Plašim se mnogih stvari.');
insert into question(question_layer, detection_type, positive, text)
values (0, 4, true, 'Postoje ljudi pojave koji mi se gade.');
insert into question(question_layer, detection_type, positive, text)
values (0, 4, true, 'Kada vidim prosjaka na ulici uhvati me mučnine.');
insert into question(question_layer, detection_type, positive, text)
values (0, 4, true, 'Često imam potrebu da izteram pravdu do kraja.');
insert into question(question_layer, detection_type, positive, text)
values (0, 4, true, 'Zgržen sam mnogim pojavama u našem društvu.');
insert into question(question_layer, detection_type, positive, text)
values (0, 4, false, 'Uopšte ne osećam transfer blama.');
insert into question(question_layer, detection_type, positive, text)
values (0, 4, true, 'Nemam problem da osudim postupke drugih.');
insert into question(question_layer, detection_type, positive, text)
values (1, 4, true, 'Osećam odbojnost prema spoljašnjem svetu.');
insert into question(question_layer, detection_type, positive, text)
values (1, 4, true, 'Često osećam gađenje.');
insert into question(question_layer, detection_type, positive, text)
values (1, 4, true, 'Razočaran sam u druge.');
insert into question(question_layer, detection_type, positive, text)
values (1, 4, true, 'Ne slažem se sa mišljenjem druge.');
------------------------------------------ ANGRY ------------------------------------------
insert into question(question_layer, detection_type, positive, text)
values (0, 5, true, 'U prošlosti sam bio mnogo puta odbačen.');
insert into question(question_layer, detection_type, positive, text)
values (0, 5, true, 'Imam potrebu da preispitujem pojave u svojem okruženju.');
insert into question(question_layer, detection_type, positive, text)
values (0, 5, false, 'Retko kad se osećam odsutno.');
insert into question(question_layer, detection_type, positive, text)
values (0, 5, true, 'U situjacijama koje su neprijatne ja se najčešće povučem.');
insert into question(question_layer, detection_type, positive, text)
values (0, 5, true, 'Iritira me prisustvo drugih ljudi.');
insert into question(question_layer, detection_type, positive, text)
values (0, 5, true, 'I najmanja sitnica može da me razbesni.');
insert into question(question_layer, detection_type, positive, text)
values (0, 5, true, 'U koliko ti druga osoba dozvoli, treba da iskoristiš.');
insert into question(question_layer, detection_type, positive, text)
values (0, 5, true, 'Drugi ljudi me često provociraju.');
insert into question(question_layer, detection_type, positive, text)
values (0, 5, true, 'U koliko bi moj partner popio piće sa kolegom sa posla osećao bih ljutnju.');
insert into question(question_layer, detection_type, positive, text)
values (0, 5, true, 'Ponekad ne mogu da kontrolišem nalet besa.');
insert into question(question_layer, detection_type, positive, text)
values (0, 5, false, 'Nemam utisak da su mi narušena osnovna ljudska prava.');
insert into question(question_layer, detection_type, positive, text)
values (0, 5, true, 'Drugi ljudi su nepravedni prema meni.');
insert into question(question_layer, detection_type, positive, text)
values (0, 5, true, 'U prošlosti sam bio žrtva tuđih podsmeha.');
insert into question(question_layer, detection_type, positive, text)
values (0, 5, false, 'Ljude me uglavnom ispoštuju.');--Ne pamtim kada sam poslednji put bio ispoštovan.
insert into question(question_layer, detection_type, positive, text)
values (0, 5, true, 'Kada se dogovorim za kafu sa nekim često se desi da se neko ne pojavi.');
insert into question(question_layer, detection_type, positive, text)
values (0, 5, true, 'Mnogi ljudi su me tokom života izdali.');
insert into question(question_layer, detection_type, positive, text)
values (1, 5, true, 'Smatram da mogu da nađem prednosti i mane u svakoj situaciji.');
insert into question(question_layer, detection_type, positive, text)
values (1, 5, true, 'Ponekad imam utisak da se stvari dešavaju dok ja nisam prisutan.');
insert into question(question_layer, detection_type, positive, text)
values (1, 5, true, 'Trudim se da održim pozitivno raspoloženje ali uprkos tome mnogo toga me iznervira.');
insert into question(question_layer, detection_type, positive, text)
values (1, 5, true, 'Ponekad sam imao fizičke obračune sa drugim ljudima.');
insert into question(question_layer, detection_type, positive, text)
values (1, 5, true, 'Bes koji osećam teško kontrolisati.');
insert into question(question_layer, detection_type, positive, text)
values (1, 5, false, 'Smatram da vredi živeti u ovom svetu.');--Smatram da ne vredi živeti u ovom svetu iz opačenih vrednosti.
insert into question(question_layer, detection_type, positive, text)
values (1, 5, true, 'U prošlosti se dešavalo da me drugi ljudi doživljavaju kao „dvorsku ludu“.');
insert into question(question_layer, detection_type, positive, text)
values (1, 5, true, 'Kada vratim film unazad više puta sam bio ostavljen/napušten nego ispoštovan.');
------------------------------------------ FEARFUL ------------------------------------------
insert into question(question_layer, detection_type, positive, text)
values (0, 6, true, 'Kada sam sa društvom osećam se kao da svi gledaju u mene.');
insert into question(question_layer, detection_type, positive, text)
values (0, 6, true, 'Ponekad je dovoljna sitnica da se uznemirim.');
insert into question(question_layer, detection_type, positive, text)
values (0, 6, true, 'Smatram da nisam uspeo da ostvarim neke stvari jer su ljudi imali predrasude prema meni.');
insert into question(question_layer, detection_type, positive, text)
values (0, 6, true, 'Često sam bio isključen iz grupa čiji član sam želeo da budem.');
insert into question(question_layer, detection_type, positive, text)
values (0, 6, true, 'Nikome nije stalo do mene.');
insert into question(question_layer, detection_type, positive, text)
values (0, 6, false, 'Lako mi je da pronađem sopstvane vrednosti.');
insert into question(question_layer, detection_type, positive, text)
values (0, 6, true, 'Drugi ljudi su mnogo bolji od mene.');
insert into question(question_layer, detection_type, positive, text)
values (0, 6, true, 'Šta god sam do sada započeo nikako nisam mogao da budem dovoljno dobar u tome.');
insert into question(question_layer, detection_type, positive, text)
values (0, 6, true, 'Ponekad osećam kao da nosim ogroman teret na svojim leđima.');
insert into question(question_layer, detection_type, positive, text)
values (0, 6, true, 'Moji misli su ponekad toliko brze da se zbunim.');
insert into question(question_layer, detection_type, positive, text)
values (0, 6, true, 'Plašim se više nego drugi ljudi.');--
insert into question(question_layer, detection_type, positive, text)
values (0, 6, false, 'Ukoliko bih tražio pomoć od drugih ljudi verujem da bih je dobio.');
insert into question(question_layer, detection_type, positive, text)
values (1, 6, true, 'Pretnja drugih ljudi nije mi nepoznato.');
insert into question(question_layer, detection_type, positive, text)
values (1, 6, true, 'Osećam da sam u više situacija bio odbačen nego prihvaćen.');
insert into question(question_layer, detection_type, positive, text)
values (1, 6, true, 'Ponekad mislim da nisam dovoljno jak da se nosim sa svim problemima.');
insert into question(question_layer, detection_type, positive, text)
values (1, 6, true, 'Trudim se da ohrabrujem sam sebe ali ponekad mi to teško ide.');
insert into question(question_layer, detection_type, positive, text)
values (1, 6, true, 'Mnogo vremena provodim razmišljajući o tome šta bi moglo da uđe po zlu.');
insert into question(question_layer, detection_type, positive, text)
values (1, 6, true, 'Ponekad mi prijatelji kažu da ne treba da se plašim toliko stvari.');
------------------------------------------ BAD ------------------------------------------
insert into question(question_layer, detection_type, positive, text)
values (0, 7, true, 'Često mi je svejedno kako ću provesti dan.');
insert into question(question_layer, detection_type, positive, text)
values (0, 7, true, 'Izgubio sam interesovanje za mnoge stvari.');
insert into question(question_layer, detection_type, positive, text)
values (0, 7, true, 'Ponekad osećam kao da ne uspevam da ispunim sve obaveze.');
insert into question(question_layer, detection_type, positive, text)
values (0, 7, true, 'Često sam u žurbi.');
insert into question(question_layer, detection_type, positive, text)
values (0, 7, true, 'Primećujem dosta stvari koji me uznemiruju.');
insert into question(question_layer, detection_type, positive, text)
values (0, 7, true, 'Volela bih da mogu da kontrolišem sve.'); -- jel ovo negativan?
insert into question(question_layer, detection_type, positive, text)
values (0, 7, false, 'U poslednje vreme ne spavam više nego inače.');
insert into question(question_layer, detection_type, positive, text)
values (0, 7, true, 'Primećujem da moja koncentracija lošija/slabija nego pre.');
insert into question(question_layer, detection_type, positive, text)
values (1, 7, false, 'Lako mi je da pronađem nešto sto će mi okupirati pažnju.');--U poslednje mi teško da pronađem nešto sto će mi okupirati pažnju.
insert into question(question_layer, detection_type, positive, text)
values (1, 7, true, 'Većinu vremena sam zauzet.');
insert into question(question_layer, detection_type, positive, text)
values (1, 7, true, 'Često osećam kao da ne uspevam da se odmorim ni nakon dovoljno sati sna.');
insert into question(question_layer, detection_type, positive, text)
values (1, 7, true, 'Umoran sam.');
------------------------------------------ SURPRISED ------------------------------------------
insert into question(question_layer, detection_type, positive, text)
values (0, 8, true, 'Mnogi stvari me šokiraju.');
insert into question(question_layer, detection_type, positive, text)
values (0, 8, true, 'Neprijatno sam iznenađen stvarima iz svog okruženja.');
insert into question(question_layer, detection_type, positive, text)
values (0, 8, true, 'Ponekad mi deluje da ništa nije dovoljno dobro.');
insert into question(question_layer, detection_type, positive, text)
values (0, 8, true, 'Zbunjuje me način na koju funkcionišu ljudi oko mene.');
insert into question(question_layer, detection_type, positive, text)
values (0, 8, true, 'Često se pozitivno iznenadim.');
insert into question(question_layer, detection_type, positive, text)
values (0, 8, true, 'Ostanem u čudu kada vidim šta je neko uspeo da postigne.');
insert into question(question_layer, detection_type, positive, text)
values (0, 8, false, 'Uglavnom nema ništa bih jako želeo da postignem.');--Postoje stvari koje bih jako želeo da postignem.
insert into question(question_layer, detection_type, positive, text)
values (0, 8, false, 'Retko kad osećam da imam mnogo energije.');
insert into question(question_layer, detection_type, positive, text)
values (1, 8, true, 'Zaprepašćen sam načinom na koje funkcioniše društvo.');
insert into question(question_layer, detection_type, positive, text)
values (1, 8, true, 'Često se osećam zbunjeno.');
insert into question(question_layer, detection_type, positive, text)
values (1, 8, true, 'Divim se ljudima iz svoje okoline.');
insert into question(question_layer, detection_type, positive, text)
values (1, 8, true, 'Uzbuđen sam povodom stvari koje me čekaju u budućnosti.');
------------------------------------------ HAPPY ------------------------------------------
insert into question(question_layer, detection_type, positive, text)
values (0, 9, true, 'U toku dana osećam nalete pozitivne energije.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, true, 'Jedno od vrednosti koje se držim je nada.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, false, 'Ne osećam potrebu da budem blizak sa drugom osobom.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, true, 'Tuđa osećanja mi znače.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, true, 'Često se osećam zahvalnost prema stvarima koji su mi se desile.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, true, 'Smatram da su drugi ljudi vredni/ljubavi.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, true, 'Drugi ljudi mi često kažu da sam kreativna osoba.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, true, 'Često imam potrebu da istupim za ljude koje nemaju snagu da se bore sami.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, true, 'Smatram da je svako ljudsko biće vredno sama po sebi.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, false, 'Tokom odrastanja nisam osetio da me drugi poštuju.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, true, 'Verujem u svoje sposobnosti.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, false, 'Nisam zadovoljan sa svojim postignućima.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, true, 'Imam želju da se interesujem za stvari koje nisu moja struka.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, true, 'Voleo bih da tokom svog života saznam što više stvari.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, true, 'Mogu da pronađem sreću u skoro svemu.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, true, 'Često se osećam kao da ništa me ne sprečava.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, true, 'Kada neko u društvu baci foru na moj račun ja se ne ljutim.');
insert into question(question_layer, detection_type, positive, text)
values (0, 9, true, 'Prija mi kada se nešto dešava oko mene.');
insert into question(question_layer, detection_type, positive, text)
values (1, 9, true, 'Često verujem da će se u budućnosti dogoditi dobre stvari.');
insert into question(question_layer, detection_type, positive, text)
values (1, 9, true, 'Meni se može verovati.');
insert into question(question_layer, detection_type, positive, text)
values (1, 9, true, 'Smatram da mir ima cenu.');
insert into question(question_layer, detection_type, positive, text)
values (1, 9, false, 'Retko kad osećam toliko snagu da započnem nove stvari.'); --
insert into question(question_layer, detection_type, positive, text)
values (1, 9, true, 'Osećam se prihvaćeno.');
insert into question(question_layer, detection_type, positive, text)
values (1, 9, false, 'Do sada nisam postigao sve što sam želeo.');
insert into question(question_layer, detection_type, positive, text)
values (1, 9, true, 'Uvek pronađem nešto što me zaokupira.');
insert into question(question_layer, detection_type, positive, text)
values (1, 9, true, 'Generalno sam zadovoljan sa životom.');
insert into question(question_layer, detection_type, positive, text)
values (1, 9, true, 'Prija mi okruženje u kom se stalno nešto dešava.');

insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)
values (2, 'Jovan', 'Jovanović', 'jj@ex.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 2000, 0, 'programer');

insert into emotion_result(user_id, detected, time) values (2, 3, '2023-05-18 18:57:58.508-07');

insert into answer(user_id, question_id, score, time) values (2, 95, 4, '2023-05-18 18:57:58.508-07');
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
insert into answer(user_id, question_id, score, time) values (2, 131, 1, '2023-05-18 18:57:58.508-07');
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

insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)
values (1, 'Tamara', 'Konjevic', 'tamara@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 2000, 0, 'psiholog');

insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)
values (1, 'Mina', 'Minovic', 'mm@ex.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 2000, 0, 'psiholog');
insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)
values (1, 'Luka', 'Lukic', 'll@ex.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 2000, 1, 'psiholog');
insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)
values (1, 'Lazar', 'Lazarevic', 'llll@ex.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 2000, 1, 'psiholog');
insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)
values (1, 'Lazar', 'Minovic', 'ml@ex.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 2000, 1, 'psiholog');

insert into users(role_id, name, surname, email, password, enabled, year_of_birth, gender, job)values
    (2, 'Ivan', 'Ivanovic', 'ivan@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, 1996, 1, 'student');

insert into user_psychologist(user_id, psychologist_id) values (2, 3);


insert into emotion_result(user_id, detected, time) values (1, 10, '2023-05-20 18:57:58.508-07' );
insert into emotion_result(user_id, detected, time) values (1, 12, '2023-05-21 18:57:58.508-07' );
insert into emotion_result(user_id, detected, time) values (1, 14, '2023-05-22 18:57:58.508-07' );
insert into emotion_result(user_id, detected, time) values (1, 2, '2023-05-23 18:57:58.508-07' );
insert into emotion_result(user_id, detected, time) values (1, 15, '2023-05-24 18:57:58.508-07' );

insert into answer(user_id, question_id, score, time) values (1, 1, 3, '2023-05-20 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 2, 4, '2023-05-20 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 3, 2, '2023-05-20 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 4, 5, '2023-05-20 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 5, 1, '2023-05-20 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 6, 3, '2023-05-20 18:57:58.508-07');


insert into answer(user_id, question_id, score, time) values (1, 45, 3, '2023-05-21 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 46, 4, '2023-05-21 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 47, 2, '2023-05-21 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 48, 5, '2023-05-21 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 49, 1, '2023-05-21 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 50, 3, '2023-05-21 18:57:58.508-07');

insert into answer(user_id, question_id, score, time) values (1, 72, 4, '2023-05-22 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 73, 5, '2023-05-22 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 74, 1, '2023-05-22 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 75, 2, '2023-05-22 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 76, 1, '2023-05-22 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 77, 5, '2023-05-22 18:57:58.508-07');

insert into answer(user_id, question_id, score, time) values (1, 78, 5, '2023-05-23 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 79, 5, '2023-05-23 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 80, 5, '2023-05-23 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 81, 2, '2023-05-23 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 82, 2, '2023-05-23 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 83, 4, '2023-05-23 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (1, 84, 4, '2023-05-23 18:57:58.508-07');

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

-- dodati uslovi za cos ank za ivana za datume
insert into emotion_result(user_id, detected, time) values (8, 10, '2023-05-20 18:57:58.508-07' );

insert into answer(user_id, question_id, score, time) values (8, 1, 3, '2023-05-20 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 2, 4, '2023-05-20 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 3, 2, '2023-05-20 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 4, 5, '2023-05-20 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 5, 1, '2023-05-20 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 6, 3, '2023-05-20 18:57:58.508-07');

insert into emotion_result(user_id, detected, time) values (8, 10, '2023-05-21 18:57:58.508-07' );

insert into answer(user_id, question_id, score, time) values (8, 1, 3, '2023-05-21 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 2, 4, '2023-05-21 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 3, 2, '2023-05-21 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 4, 5, '2023-05-21 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 5, 1, '2023-05-21 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 6, 3, '2023-05-21 18:57:58.508-07');

insert into emotion_result(user_id, detected, time) values (8, 10, '2023-05-24 18:57:58.508-07' );

insert into answer(user_id, question_id, score, time) values (8, 1, 3, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 2, 4, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 3, 2, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 4, 5, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 5, 1, '2023-05-24 18:57:58.508-07');
insert into answer(user_id, question_id, score, time) values (8, 6, 3, '2023-05-24 18:57:58.508-07');