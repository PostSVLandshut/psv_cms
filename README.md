# psv_cms
CMS for Post SV Landshut

## Entities
-Artikel {ID, Content, Group(Kategorie), creatingDate, PublishDate, Klicks, Title(unique?), Author, freigeben, #words(?)}


ArtikelGroup

-Author_Group {GID, Name}
    -Administrator
    -Moderator SW (system wide)
    -Moderator GW (group wide)
    -User