# Toggl API Notes

## Base URL Info
* `base_url="https://www.toggl.com/api/v8"`
* `username=API_KEY`
* `password="api_token"`

## URLs by Return Type
- **Return: `User`**
  + `GET` `/me`
  + `PUT` `/me`
- **Return: `UserExtended`**
  + `GET` `/me?with_related_data=true`
- **Return: `Workspace[]`**
  + `GET` `/workspaces`
- **Return: `Workspace`**
  + `GET` `/workspaces/{workspace_id}`
  + `PUT` `/workspaces/{workspace_id}`
- **Return: `Client[]`**
  + `GET` `/workspaces/{workspace_id}/clients`
  + `GET` `/clients`
- **Return: `Client`**
  + `POST` `/clients`
  + `GET` `/clients/{client_id}`
  + `PUT` `/clients/{client_id}`
- **Return: `Project[]`**
  + `GET` `/workspaces/{workspace_id}/projects`
  + `GET` `/clients/{client_id}/projects`
- **Return: `Project`**
  + `POST` `/projects`
  + `GET` `/projects/{project_id}`
  + `PUT` `/projects/{project_id}`
- **Return: `Tag[]`**
  + `GET` `/workspaces/{workspace_id}/tags
- **Return: `Tag`**
  + `POST` `/tags`
  + `PUT` `/tags/{tag_id}`
- **Return: `TimeEntry[]`**
  + `GET` `/time_entries`
  + `GET` `/time_entries?start_date={start_date}&end_date={end_date}`
  + `PUT` `/time_entries/{time_entry_ids}` *(CSV)*
- **Return: `TimeEntry`**
  + `POST` `/time_entries`
  + `POST` `/time_entries/start`
  + `PUT` `/time_entries/{time_entry_id}`
  + `PUT` `/time_entries/{time_entry_id}/stop`
  + `GET` `/time_entries/{time_entry_id}`
  + `GET` `/time_entries/current`
- **Return: 200 or 4xx**
  + `DELETE` `/clients/{client_id}`
  + `DELETE` `/projects/{project_id}`
  + `DELETE` `/projects/{project_ids}` *(CSV)*
  + `DELETE` `/tags/{tag_id}`
  + `DELETE` `/time_entries/{time_entry_id}`
