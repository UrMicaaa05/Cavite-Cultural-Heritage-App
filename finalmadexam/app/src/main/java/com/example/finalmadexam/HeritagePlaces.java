package com.example.finalmadexam;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * All Cavite cultural heritage sites.
 * Moved from com.fam.favlocation → com.example.finalmadexam.
 */
public class HeritagePlaces {

    public static List<HeritagePlace> getAll() {
        List<HeritagePlace> list = new ArrayList<>();

        list.add(new HeritagePlace(
                "Bundok Nagpatong Historical Marker",
                "Maragondon, Cavite",
                "A sacred mountain where Andres Bonifacio and the Katipunan took refuge during the Philippine Revolution. Its rugged terrain sheltered revolutionaries in their final, desperate stand.",
                "Natural & Revolutionary Sites",
                14.26295451154644, 120.71761620350651, 15f,
                R.drawable.bundok_nagpatong
        ));

        list.add(new HeritagePlace(
                "Diocesan Shrine of Saint Augustine and Parish of the Holy Cross",
                "Tanza, Cavite",
                "A centuries-old parish church that served as a spiritual center for the people of Tanza. Its walls witnessed the turbulent years of Spanish colonial rule and the birth of Filipino nationalism.",
                "Churches & Parishes",
                14.401995005817806, 120.8570677004163, 15f,
                R.drawable.sta_cruz_tanza
        ));

        list.add(new HeritagePlace(
                "Felipe Calderon Monument and Historical Marker",
                "San Agustin, Tanza, Cavite",
                "Marker honoring Felipe Calderon, the principal author of the Malolos Constitution — the first democratic constitution in Asia. A lawyer and patriot born from the soil of Cavite.",
                "Heroes & Markers",
                14.39954893036462, 120.85534814213644, 15f,
                R.drawable.place_felipe_calderon
        ));

        list.add(new HeritagePlace(
                "Cavite National High School",
                "Cavite City, Cavite",
                "One of the oldest public secondary schools in the Philippines, standing on historically significant ground in Cavite City, a city steeped in colonial and revolutionary heritage.",
                "Historic Structures",
                14.483656837023226, 120.8972752364548, 15f,
                R.drawable.place_cavite_national_hs
        ));

        list.add(new HeritagePlace(
                "Labintatlong Martir ng Kabite",
                "Governor's Drive cor. City Hall Road, Trece Martires, Cavite",
                "Memorial to the thirteen martyrs of Cavite — Filipino patriots executed by Spanish colonial authorities. Their sacrifice ignited the flames of the Cavite Mutiny of 1872.",
                "Revolutionary Sites",
                14.281160933300729, 120.87079118040351, 15f,
                R.drawable.place_labintatlong_martir
        ));

        list.add(new HeritagePlace(
                "Site of the Proclamation of Philippine Independence",
                "Emilio Aguinaldo Shrine, Kawit, Cavite",
                "On June 12, 1898, General Emilio Aguinaldo proclaimed Philippine independence from the window of his ancestral home, marking the birth of the Filipino nation.",
                "Revolutionary Sites",
                14.446272690538004, 120.90664743695336, 16f,
                R.drawable.place_proclamation_site
        ));

        list.add(new HeritagePlace(
                "Bahay na Pinaglitisan kay Andres Bonifacio",
                "Col C. Riel Street, Maragondon, Cavite",
                "The house where Andres Bonifacio, Supremo of the Katipunan, was tried, convicted, and sentenced to death in May 1897 — a somber landmark in Philippine revolutionary history.",
                "Natural & Revolutionary Sites",
                14.276975740533304, 120.73686476338925, 16f,
                R.drawable.place_bahay_bonifacio
        ));

        list.add(new HeritagePlace(
                "Fort San Felipe",
                "Cavite City, Cavite",
                "A Spanish colonial fortress built in the 17th century to defend Manila Bay from foreign invaders. Fort San Felipe was the seat of Spanish naval power in the Philippines.",
                "Historic Structures",
                14.48238476906825, 120.91664536631852, 16f,
                R.drawable.place_fort_san_felipe
        ));

        list.add(new HeritagePlace(
                "Emilio Aguinaldo Shrine",
                "Kawit, Cavite",
                "The ancestral home of General Emilio Aguinaldo, first President of the Philippines. The iconic window from which independence was declared still stands as a symbol of Filipino freedom.",
                "Revolutionary Sites",
                14.44528129952943, 120.90694663312382, 16f,
                R.drawable.place_aguinaldo_shrine
        ));

        list.add(new HeritagePlace(
                "Museo ni Heneral Baldomero Aguinaldo",
                "Binakayan, Kawit, Cavite",
                "Ancestral home of General Baldomero Aguinaldo, a key military leader of the Philippine Revolution and cousin of Emilio Aguinaldo. A witness to Cavite's revolutionary spirit.",
                "Heroes & Markers",
                14.448028953476046, 120.92360051043795, 15f,
                R.drawable.place_baldomero_house
        ));

        list.add(new HeritagePlace(
                "The Tejeros Convention",
                "Barrio Tejeros, General Trias, Cavite",
                "Site of the historic March 1897 convention where Emilio Aguinaldo was elected President, superseding Andres Bonifacio — a turning point that reshaped the Philippine Revolution.",
                "Revolutionary Sites",
                14.401323814782165, 120.86052496671462, 15f,
                R.drawable.place_tejeros_convention
        ));

        list.add(new HeritagePlace(
                "Battle of Alapan",
                "Alapan Elementary School, Alapan, Imus, Cavite",
                "Scene of the first military victory under the Philippine flag on May 28, 1898. Filipino forces under Aguinaldo defeated Spanish troops here, days before independence was proclaimed.",
                "Battle Sites",
                14.40430782169251, 120.91513252489824, 15f,
                R.drawable.place_battle_alapan
        ));

        list.add(new HeritagePlace(
                "Sarayba House",
                "General Trias, Cavite",
                "A well-preserved ancestral house that stands as a testament to colonial-era Filipino architecture and the prominent role of the Sarayba family in Cavite's history.",
                "Historic Structures",
                14.386507921131969, 120.87995443195773, 15f,
                R.drawable.place_sarayba_house
        ));

        list.add(new HeritagePlace(
                "Arsenal ng Imus",
                "Imus, Cavite",
                "The revolutionary arsenal of Imus served as a weapons depot and manufacturing center for the Katipunan forces during the Philippine Revolution against Spanish colonial rule.",
                "Historic Structures",
                14.429969136396256, 120.94014680370012, 15f,
                R.drawable.place_arsenal_imus
        ));

        list.add(new HeritagePlace(
                "Diocesan Shrine and Parish of St. Mary Magdalene",
                "Kawit, Cavite",
                "The historic parish church of Kawit, whose bells rang on June 12, 1898 to celebrate Philippine independence. A living monument of faith intertwined with revolution.",
                "Churches & Parishes",
                14.4417, 120.9000, 16f,
                R.drawable.place_simbahan_kawit
        ));

        list.add(new HeritagePlace(
                "Pamahalaang Bayan ng Kawit (1896)",
                "Kawit, Cavite",
                "Site of the first revolutionary local government established in Kawit in 1896, marking one of the earliest acts of Filipino self-governance during the revolution against Spain.",
                "Revolutionary Sites",
                14.444477116302204, 120.90338874569217, 15f,
                R.drawable.place_pamahalaang_kawit
        ));

        list.add(new HeritagePlace(
                "Diocesan Shrine and Cathedral Parish of Our Lady of the Pillar",
                "Imus, Cavite",
                "The Cathedral of Imus, a grand Spanish colonial church that has anchored the spiritual life of Imus for centuries. An NHCP-marked heritage landmark of profound historical significance.",
                "Churches & Parishes",
                14.429741800995233, 120.93619247742255, 16f,
                R.drawable.place_katedral_imus
        ));

        list.add(new HeritagePlace(
                "Candido Tria Tirona Monument and Historical Marker",
                "Kawit Church, Kaligtasan Street, Kawit, Cavite",
                "Marker honoring General Candido Tirona, a revolutionary general from Kawit who played a crucial role in the battles of the Philippine Revolution in Cavite.",
                "Heroes & Markers",
                14.445074195606411, 120.90343725965782, 16f,
                R.drawable.place_tirona_marker
        ));

        list.add(new HeritagePlace(
                "Organization of Revolutionary Government",
                "Tanza, Cavite",
                "The site where the Revolutionary Government of the Philippines was formally organized in 1897, consolidating Katipunan forces under a unified political and military command.",
                "Revolutionary Sites",
                14.409020997280827, 120.85932792154198, 15f,
                R.drawable.place_org_revolutionary_gov
        ));

        list.add(new HeritagePlace(
                "Bantayog ng Labanan sa Binakayan",
                "Covelandia Rd, Kawit, 4104 Cavite",
                "The Battle of Imus was a decisive engagement in 1896 where Caviteno revolutionaries captured the Spanish cuartel, establishing Imus as a stronghold of the Philippine Revolution.",
                "Battle Sites",
                14.45915347490724, 120.92235359999914, 15f,
                R.drawable.place_labanan_imus
        ));

        list.add(new HeritagePlace(
                "Mile-Long Barracks",
                "Corregidor Island, Cavite",
                "The Rock — a fortified island at the mouth of Manila Bay that served as the last line of American-Filipino defense in World War II. Now a solemn memorial to those who fought and fell.",
                "Historic Structures",
                14.381803063575093, 120.57513671345987, 13f,
                R.drawable.place_corregidor
        ));

        list.add(new HeritagePlace(
                "Ermita de Porta Baga",
                "Samonte Park, Judge Ibanez Street, San Roque, Cavite City",
                "A colonial-era hermitage and historic gate that once marked the entrance to the old port city of Cavite. One of the few surviving Spanish colonial structures in the province.",
                "Historic Structures",
                14.482411830138302, 120.90921100438466, 17f,
                R.drawable.place_ermita_porta_baga
        ));

        list.add(new HeritagePlace(
                "Casa Hacienda De Naic",
                "Naic, Cavite",
                "A historic colonial hacienda house in Naic that served as a meeting place for revolutionary leaders. Its ancestral walls echo with the whispers of those who planned the uprising.",
                "Historic Structures",
                14.3205983134059, 120.76352653008755, 15f,
                R.drawable.place_casa_hacienda_naic
        ));

        list.add(new HeritagePlace(
                "Bridge of Isabel II",
                "Imus, Cavite",
                "A historic stone bridge constructed during the Spanish colonial period, named after Queen Isabel II of Spain. One of the oldest surviving Spanish-built bridges in the Philippines.",
                "Historic Structures",
                14.43036567548531, 120.94027038751656, 16f,
                R.drawable.place_bridge_isabel
        ));

        list.add(new HeritagePlace(
                "Simbahan ng Heneral Trias",
                "General Trias, Cavite",
                "The parish church of General Trias, a heritage structure that witnessed the revolutionary fervor of 1896. Named after General Miguel Malvar's ally, General Trias himself.",
                "Churches & Parishes",
                14.3867, 120.8817, 16f,
                R.drawable.place_simbahan_gen_trias
        ));

        list.add(new HeritagePlace(
                "Tagaytay Ridge Landing",
                "Tagaytay, Cavite",
                "A strategic highland ridge overlooking Taal Lake and Volcano, used as a military vantage point during WWII. The breathtaking ridge also holds markers of wartime significance.",
                "Natural & Revolutionary Sites",
                14.390993959927187, 120.87705876692544, 14f,
                R.drawable.place_tagaytay_ridge
        ));

        list.add(new HeritagePlace(
                "Emilio Aguinaldo y Famy",
                "Rosario, Cavite",
                "A biographical marker honoring the life of General Emilio Aguinaldo in Rosario, commemorating his enduring legacy as the first President of the Philippine Republic.",
                "Heroes & Markers",
                14.401295224795273, 120.86065182062877, 15f,
                R.drawable.place_aguinaldo_famy
        ));

        list.add(new HeritagePlace(
                "Pagpupulong sa Bacoor Site",
                "Bacoor, Cavite",
                "The site of a critical revolutionary assembly in Bacoor where Katipunan leaders convened to plan military strategy. A forgotten yet vital node in the web of the 1896 revolution.",
                "Revolutionary Sites",
                14.459543087169589, 120.93990959177896, 15f,
                R.drawable.place_pagpupulong_bacoor
        ));

        list.add(new HeritagePlace(
                "Immaculate Conception Parish Church",
                "Dasmarinas, Cavite",
                "The historic church of Dasmarinas, a Spanish colonial parish that has stood for centuries as a center of faith, community, and heritage in one of Cavite's fastest-growing cities.",
                "Churches & Parishes",
                14.333414349134436, 120.9312271395633, 16f,
                R.drawable.place_simbahan_dasmarinas
        ));

        list.add(new HeritagePlace(
                "Hen. Baldomero Aguinaldo y Baloy",
                "Binakayan, Kawit, Cavite",
                "Biographical marker for General Baldomero Aguinaldo (1869-1915), a military hero of the Philippine Revolution who commanded forces in the decisive battles around Binakayan and Kawit.",
                "Heroes & Markers",
                14.450070275910207, 120.92344851396403, 15f,
                R.drawable.place_baldomero_marker
        ));

        return list;
    }

    public static Map<String, List<HeritagePlace>> getGrouped() {
        Map<String, List<HeritagePlace>> map = new LinkedHashMap<>();
        for (HeritagePlace p : getAll()) {
            map.computeIfAbsent(p.category, k -> new ArrayList<>()).add(p);
        }
        return map;
    }
}