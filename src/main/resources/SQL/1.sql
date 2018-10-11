
CREATE FUNCTION set_created_date() RETURNS trigger AS $$
BEGIN
  NEW.created_date := CURRENT_TIME;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;


DO $$
DECLARE
  t record;
BEGIN
  FOR t IN
  SELECT * FROM information_schema.columns
  WHERE column_name = 'created_date'
  LOOP
    EXECUTE format('CREATE TRIGGER set_created_date
                        BEFORE INSERT ON %I.%I
                        FOR EACH ROW EXECUTE PROCEDURE set_created_date()',
                   t.table_schema, t.table_name);
  END LOOP;
END;
$$ LANGUAGE plpgsql;



CREATE FUNCTION set_modified_date() RETURNS trigger AS $$
BEGIN
  NEW.modified_date := CURRENT_TIME;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;


DO $$
DECLARE
  t record;
BEGIN
  FOR t IN
  SELECT * FROM information_schema.columns
  WHERE column_name = 'modified_date'
  LOOP
    EXECUTE format('CREATE TRIGGER set_modified_date
                        BEFORE UPDATE ON %I.%I
                        FOR EACH ROW EXECUTE PROCEDURE set_modified_date()',
                   t.table_schema, t.table_name);
  END LOOP;
END;
$$ LANGUAGE plpgsql;



CREATE TABLE sys_list
(
  id serial,
  keycolumn text NOT NULL UNIQUE ,
  valuecolumn jsonb,
  created_date timestamp DEFAULT current_timestamp
)
