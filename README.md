# Symbol counter service

## Get started
1. `mvn clean package`
2. `mvn spring-boot:run`

## Request example:
GET `/api/count-symbols`
```json
{
    "text": "aaaaabcccc"
}
```

Response:
```json
{
    "a": 5,
    "c": 4,
    "b": 1
}
```