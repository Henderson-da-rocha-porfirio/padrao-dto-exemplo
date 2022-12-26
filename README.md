# DTO

- DATA TRANSFER OBJECT = objeto de transferencia de dados
- padrão de transporte de dados entre diferentes camadas no sistema ou módulos desse.
- Agrupa um conjunto de propriedades de uma ou mais classes entidades do model apenas com as propriedades necessárias.

Ex:
- João deseja unificar duas ou três entidades em seu projeto. Para isso ele usará classe DTO seguindo estes passos:
1. Cria uma classe DTO
- Obs: o nome pode ser criado como queira, mas é importante não colocar resource porque o dto é o modelo de representação(representation) do recurso e não o recurso em si.
2. Define as propriedades que deseja serializar(retornar para o consumidor da api)
3. Isso é instanciado no controlador(controller) que atribui estas propriedades.

-Vantagens:

1. Oferecendo assim total controle do que se deseja retornar.
2. Isso fica totalmente desacoplado com o domain model
3. No controller, não retorna a entidade (do domain model), mas a instância de um tipo que foi criado, no caso,
   do DTO (classe de modelo de representação do recurso / representation model)


SEQUENCIA:
1. classe DTO
2. classe controller (caso nao exista)
3. 

