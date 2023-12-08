package nuitinfo23.backend.io.controller;

import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.sparql.SPARQLRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SparqlController {

    private static final String SPARQL_ENDPOINT = "https://query.wikidata.org/sparql";
    private static final String SPARQL_QUERY = "PREFIX wd: <http://www.wikidata.org/entity/>" +
            "PREFIX wdt: <http://www.wikidata.org/prop/direct/>" +
            "PREFIX wikibase: <http://wikiba.se/ontology#>" +
            "SELECT ?person ?personLabel ?description ?image WHERE {" +
            "  ?person wdt:P31 wd:Q5 ;" +
            "          wdt:P101 wd:Q125928  ;" +
            "          wdt:P18 ?image ;" +
            "          rdfs:label ?personLabel ;" +
            "          schema:description ?description ." +
            "  FILTER(LANG(?personLabel) = 'en')" +
            "  FILTER(LANG(?description) = 'en')" +
            "}" +
            "LIMIT 10";

    @GetMapping("/hallOfFame")
    public String getWikidataClimateScientists() {
        StringBuilder resultStringBuilder = new StringBuilder();

        try (RepositoryConnection connection = createRepositoryConnection()) {
            TupleQuery tupleQuery = connection.prepareTupleQuery(QueryLanguage.SPARQL, SPARQL_QUERY);

            try (TupleQueryResult result = tupleQuery.evaluate()) {
                // Process the result as needed
                while (result.hasNext()) {
                    BindingSet bindingSet = result.next();

                    // Adjust variable names based on your query
                    String linkToPage = bindingSet.getValue("person").stringValue();
                    String name = bindingSet.getValue("personLabel").stringValue();
                    String description = bindingSet.getValue("description").stringValue();
                    String imageUrl = bindingSet.getValue("image").stringValue();

                    resultStringBuilder.append("Person: ").append(linkToPage).append(", Label: ").append(name)
                            .append(", Description: ").append(description)
                            .append(", Image: ").append(imageUrl)
                            .append("<br>");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error executing SPARQL query: " + e.getMessage();
        }

        return resultStringBuilder.toString();
    }

    private RepositoryConnection createRepositoryConnection() {
        Repository repository = new SPARQLRepository(SPARQL_ENDPOINT);
        repository.init();

        return repository.getConnection();
    }
}
