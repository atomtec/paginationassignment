# Paginationassignment
An Android App that lists the post and details.

![Paginationassignment](assign.gif)

## Architecture 

This app uses the Google's [Paging3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview)
library to implement the paginated list with only **local data source**

The architecture is a  standard **MVVM** with UI observing the live data for the main list as 
received from the ViewModel->  PagingSource-> LocalDataSource  .

### Note 
The API does **not support pagination** so I have downladed the data and stored in DB and then used client side navigation 

