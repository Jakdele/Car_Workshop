I decided to give the user ability to set the repair time, along with date.
Unfortunately, some form input types (namely "datetime-local" and "time"), are not universally supported by browser. 
Because of that I decided to allow the user to input the date and time as string, which is then parsed to a Date type. User is advised on the correct format for any input that requires that.

LocalDates, wherever they're used, are working as intended, generating a pop-up with date picker on click.

TO DO - implement a universally working date-time picker.
