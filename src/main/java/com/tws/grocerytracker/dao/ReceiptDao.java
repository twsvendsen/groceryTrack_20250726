package com.tws.grocerytracker.dao;

import com.tws.grocerytracker.model.Receipt;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.net.URI;

public class ReceiptDao {

    private final DynamoDbClient ddbClient;
    private final DynamoDbEnhancedClient enhancedClient;

    public ReceiptDao() {
        ddbClient = DynamoDbClient.builder()
                .region(Region.US_EAST_2) // Replace with your region
                .endpointOverride(URI.create("http://localhost:8000"))
                .build();
        enhancedClient = DynamoDbEnhancedClient.builder().dynamoDbClient(ddbClient).build();
//        AWSCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
//        new AmazonEC2Client(credentialsProvider)
    }

    public void catalogueReceipt(Receipt receipt) {
        // map input and validate receipt was scanned correctly
        // mapping includes generation of uniqueIds for GroceryItems
        // store Commodity timesPurchased
        // This method might need to move to service
        DynamoDbTable<Receipt> receiptTable = enhancedClient.table("GroceryTrackReceipt", TableSchema.fromBean(Receipt.class));

        // TEMP

//        String tableName = "GroceryTrackReceipt";
//        String partitionKey = "id";
//        String sortKey = "transactionDateTime";

//        CreateTableRequest request = CreateTableRequest.builder()
//                .attributeDefinitions(
//                        AttributeDefinition.builder()
//                                .attributeName(partitionKey)
//                                .attributeType(ScalarAttributeType.S) // S for String, N for Number, B for Binary
//                                .build())
//                .keySchema(
//                        KeySchemaElement.builder()
//                                .attributeName(partitionKey)
//                                .keyType(KeyType.HASH) // HASH for partition key
//                                .build())
//                .attributeDefinitions(
//                        AttributeDefinition.builder()
//                                .attributeName(sortKey)
//                                .attributeType(ScalarAttributeType.S) // S for String, N for Number, B for Binary
//                                .build())
//                .keySchema(
//                        KeySchemaElement.builder()
//                                .attributeName(partitionKey)
//                                .keyType(KeyType.RANGE) // HASH for partition key
//                                .build())
//                .provisionedThroughput(
//                        ProvisionedThroughput.builder()
//                                .readCapacityUnits(5L)
//                                .writeCapacityUnits(5L)
//                                .build())
//                .tableName(tableName)
//                .build();

//        receiptTable.createTable();

        try {
            receiptTable.putItem(receipt);
            System.out.println("Receipt stored successfully!");
        } catch(RuntimeException ex) {
            System.out.println("Receipt store attempt failed!");
        }

        ddbClient.close();
    }

}
