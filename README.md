# Symbol counter service

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