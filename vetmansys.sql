PGDMP  (    1                |         	   vetmansys    16.2    16.2 3               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                        0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            !           1262    17205 	   vetmansys    DATABASE     �   CREATE DATABASE vetmansys WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE vetmansys;
                postgres    false            �            1259    25685    animal    TABLE     �  CREATE TABLE public.animal (
    date_of_birth date,
    animal_id bigint NOT NULL,
    customer_id bigint,
    breed character varying(255),
    color character varying(255),
    gender character varying(255),
    name character varying(255),
    species character varying(255),
    CONSTRAINT animal_gender_check CHECK (((gender)::text = ANY ((ARRAY['MALE'::character varying, 'FEMALE'::character varying])::text[])))
);
    DROP TABLE public.animal;
       public         heap    postgres    false            �            1259    25684    animal_animal_id_seq    SEQUENCE     }   CREATE SEQUENCE public.animal_animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.animal_animal_id_seq;
       public          postgres    false    216            "           0    0    animal_animal_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.animal_animal_id_seq OWNED BY public.animal.animal_id;
          public          postgres    false    215            �            1259    25695    appointment    TABLE     �   CREATE TABLE public.appointment (
    appointment_date date,
    animal_id bigint,
    appointment_id bigint NOT NULL,
    doctor_id bigint
);
    DROP TABLE public.appointment;
       public         heap    postgres    false            �            1259    25694    appointment_appointment_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointment_appointment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.appointment_appointment_id_seq;
       public          postgres    false    218            #           0    0    appointment_appointment_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.appointment_appointment_id_seq OWNED BY public.appointment.appointment_id;
          public          postgres    false    217            �            1259    25702    available_date    TABLE     }   CREATE TABLE public.available_date (
    available_date date,
    available_date_id bigint NOT NULL,
    doctor_id bigint
);
 "   DROP TABLE public.available_date;
       public         heap    postgres    false            �            1259    25701 $   available_date_available_date_id_seq    SEQUENCE     �   CREATE SEQUENCE public.available_date_available_date_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public.available_date_available_date_id_seq;
       public          postgres    false    220            $           0    0 $   available_date_available_date_id_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE public.available_date_available_date_id_seq OWNED BY public.available_date.available_date_id;
          public          postgres    false    219            �            1259    25709    customer    TABLE     �   CREATE TABLE public.customer (
    customer_id bigint NOT NULL,
    address character varying(255),
    city character varying(255),
    email character varying(255),
    name character varying(255),
    phone character varying(255)
);
    DROP TABLE public.customer;
       public         heap    postgres    false            �            1259    25708    customer_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.customer_customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.customer_customer_id_seq;
       public          postgres    false    222            %           0    0    customer_customer_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.customer_customer_id_seq OWNED BY public.customer.customer_id;
          public          postgres    false    221            �            1259    25718    doctor    TABLE     �   CREATE TABLE public.doctor (
    doctor_id bigint NOT NULL,
    address character varying(255),
    city character varying(255),
    email character varying(255) NOT NULL,
    name character varying(255),
    phone character varying(255) NOT NULL
);
    DROP TABLE public.doctor;
       public         heap    postgres    false            �            1259    25717    doctor_doctor_id_seq    SEQUENCE     }   CREATE SEQUENCE public.doctor_doctor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.doctor_doctor_id_seq;
       public          postgres    false    224            &           0    0    doctor_doctor_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.doctor_doctor_id_seq OWNED BY public.doctor.doctor_id;
          public          postgres    false    223            �            1259    25727    vaccine    TABLE     �   CREATE TABLE public.vaccine (
    protection_end_date date,
    protection_start_date date,
    animal_id bigint,
    vaccine_id bigint NOT NULL,
    code character varying(255),
    name character varying(255)
);
    DROP TABLE public.vaccine;
       public         heap    postgres    false            �            1259    25726    vaccine_vaccine_id_seq    SEQUENCE        CREATE SEQUENCE public.vaccine_vaccine_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.vaccine_vaccine_id_seq;
       public          postgres    false    226            '           0    0    vaccine_vaccine_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.vaccine_vaccine_id_seq OWNED BY public.vaccine.vaccine_id;
          public          postgres    false    225            i           2604    25688    animal animal_id    DEFAULT     t   ALTER TABLE ONLY public.animal ALTER COLUMN animal_id SET DEFAULT nextval('public.animal_animal_id_seq'::regclass);
 ?   ALTER TABLE public.animal ALTER COLUMN animal_id DROP DEFAULT;
       public          postgres    false    216    215    216            j           2604    25698    appointment appointment_id    DEFAULT     �   ALTER TABLE ONLY public.appointment ALTER COLUMN appointment_id SET DEFAULT nextval('public.appointment_appointment_id_seq'::regclass);
 I   ALTER TABLE public.appointment ALTER COLUMN appointment_id DROP DEFAULT;
       public          postgres    false    218    217    218            k           2604    25705     available_date available_date_id    DEFAULT     �   ALTER TABLE ONLY public.available_date ALTER COLUMN available_date_id SET DEFAULT nextval('public.available_date_available_date_id_seq'::regclass);
 O   ALTER TABLE public.available_date ALTER COLUMN available_date_id DROP DEFAULT;
       public          postgres    false    220    219    220            l           2604    25712    customer customer_id    DEFAULT     |   ALTER TABLE ONLY public.customer ALTER COLUMN customer_id SET DEFAULT nextval('public.customer_customer_id_seq'::regclass);
 C   ALTER TABLE public.customer ALTER COLUMN customer_id DROP DEFAULT;
       public          postgres    false    221    222    222            m           2604    25721    doctor doctor_id    DEFAULT     t   ALTER TABLE ONLY public.doctor ALTER COLUMN doctor_id SET DEFAULT nextval('public.doctor_doctor_id_seq'::regclass);
 ?   ALTER TABLE public.doctor ALTER COLUMN doctor_id DROP DEFAULT;
       public          postgres    false    224    223    224            n           2604    25730    vaccine vaccine_id    DEFAULT     x   ALTER TABLE ONLY public.vaccine ALTER COLUMN vaccine_id SET DEFAULT nextval('public.vaccine_vaccine_id_seq'::regclass);
 A   ALTER TABLE public.vaccine ALTER COLUMN vaccine_id DROP DEFAULT;
       public          postgres    false    225    226    226                      0    25685    animal 
   TABLE DATA           l   COPY public.animal (date_of_birth, animal_id, customer_id, breed, color, gender, name, species) FROM stdin;
    public          postgres    false    216   0=                 0    25695    appointment 
   TABLE DATA           ]   COPY public.appointment (appointment_date, animal_id, appointment_id, doctor_id) FROM stdin;
    public          postgres    false    218   6>                 0    25702    available_date 
   TABLE DATA           V   COPY public.available_date (available_date, available_date_id, doctor_id) FROM stdin;
    public          postgres    false    220   �>                 0    25709    customer 
   TABLE DATA           R   COPY public.customer (customer_id, address, city, email, name, phone) FROM stdin;
    public          postgres    false    222   �>                 0    25718    doctor 
   TABLE DATA           N   COPY public.doctor (doctor_id, address, city, email, name, phone) FROM stdin;
    public          postgres    false    224   @                 0    25727    vaccine 
   TABLE DATA           p   COPY public.vaccine (protection_end_date, protection_start_date, animal_id, vaccine_id, code, name) FROM stdin;
    public          postgres    false    226   \A       (           0    0    animal_animal_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.animal_animal_id_seq', 5, true);
          public          postgres    false    215            )           0    0    appointment_appointment_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.appointment_appointment_id_seq', 5, true);
          public          postgres    false    217            *           0    0 $   available_date_available_date_id_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public.available_date_available_date_id_seq', 7, true);
          public          postgres    false    219            +           0    0    customer_customer_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.customer_customer_id_seq', 5, true);
          public          postgres    false    221            ,           0    0    doctor_doctor_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.doctor_doctor_id_seq', 5, true);
          public          postgres    false    223            -           0    0    vaccine_vaccine_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.vaccine_vaccine_id_seq', 6, true);
          public          postgres    false    225            q           2606    25693    animal animal_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_pkey PRIMARY KEY (animal_id);
 <   ALTER TABLE ONLY public.animal DROP CONSTRAINT animal_pkey;
       public            postgres    false    216            s           2606    25700    appointment appointment_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT appointment_pkey PRIMARY KEY (appointment_id);
 F   ALTER TABLE ONLY public.appointment DROP CONSTRAINT appointment_pkey;
       public            postgres    false    218            u           2606    25707 "   available_date available_date_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.available_date
    ADD CONSTRAINT available_date_pkey PRIMARY KEY (available_date_id);
 L   ALTER TABLE ONLY public.available_date DROP CONSTRAINT available_date_pkey;
       public            postgres    false    220            w           2606    25716    customer customer_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customer_id);
 @   ALTER TABLE ONLY public.customer DROP CONSTRAINT customer_pkey;
       public            postgres    false    222            y           2606    25725    doctor doctor_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.doctor
    ADD CONSTRAINT doctor_pkey PRIMARY KEY (doctor_id);
 <   ALTER TABLE ONLY public.doctor DROP CONSTRAINT doctor_pkey;
       public            postgres    false    224            {           2606    25734    vaccine vaccine_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.vaccine
    ADD CONSTRAINT vaccine_pkey PRIMARY KEY (vaccine_id);
 >   ALTER TABLE ONLY public.vaccine DROP CONSTRAINT vaccine_pkey;
       public            postgres    false    226            }           2606    25740 '   appointment fk2kkeptdxfuextg5ch7xp3ytie    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT fk2kkeptdxfuextg5ch7xp3ytie FOREIGN KEY (animal_id) REFERENCES public.animal(animal_id);
 Q   ALTER TABLE ONLY public.appointment DROP CONSTRAINT fk2kkeptdxfuextg5ch7xp3ytie;
       public          postgres    false    218    216    4721            |           2606    25735 "   animal fk6pvxm5gfjqxclb651be9unswe    FK CONSTRAINT     �   ALTER TABLE ONLY public.animal
    ADD CONSTRAINT fk6pvxm5gfjqxclb651be9unswe FOREIGN KEY (customer_id) REFERENCES public.customer(customer_id);
 L   ALTER TABLE ONLY public.animal DROP CONSTRAINT fk6pvxm5gfjqxclb651be9unswe;
       public          postgres    false    222    4727    216                       2606    25750 *   available_date fkk0d6pu1wxarsoou0x2e1cc2on    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_date
    ADD CONSTRAINT fkk0d6pu1wxarsoou0x2e1cc2on FOREIGN KEY (doctor_id) REFERENCES public.doctor(doctor_id);
 T   ALTER TABLE ONLY public.available_date DROP CONSTRAINT fkk0d6pu1wxarsoou0x2e1cc2on;
       public          postgres    false    4729    220    224            �           2606    25755 #   vaccine fkne3kmh8y5pcyxwl4u2w9prw6j    FK CONSTRAINT     �   ALTER TABLE ONLY public.vaccine
    ADD CONSTRAINT fkne3kmh8y5pcyxwl4u2w9prw6j FOREIGN KEY (animal_id) REFERENCES public.animal(animal_id);
 M   ALTER TABLE ONLY public.vaccine DROP CONSTRAINT fkne3kmh8y5pcyxwl4u2w9prw6j;
       public          postgres    false    4721    216    226            ~           2606    25745 '   appointment fkoeb98n82eph1dx43v3y2bcmsl    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT fkoeb98n82eph1dx43v3y2bcmsl FOREIGN KEY (doctor_id) REFERENCES public.doctor(doctor_id);
 Q   ALTER TABLE ONLY public.appointment DROP CONSTRAINT fkoeb98n82eph1dx43v3y2bcmsl;
       public          postgres    false    224    4729    218               �   x�mϽN�0����*rF�CQ[h&�V��XN���±S�Hp�8i@l>����b�f��Md4*B�sRͱ�?�q��EԆ������ɧPb�����4�˖�����UkQ�%Q�9k)����c�1�p&$�P�N^��$��Ƽ�^�aD�m�)R(�d�5E2~��,L���B���r�h��u�yUf"uD!��(28�y[���S!N��5�DNpv��5�sM��d�%k\���E�`�rw         @   x�M���0Cѳ�K��M
���s�ȷ'�ҼLB ��I\��|a��?��l(Lރ��D
         B   x�E̱� E��e�x�O@����B���U�<�k������E�m��؂N�8<���I13{3{�#�         /  x�-�An�0E��)|�cl�EQ�6�5��R7L��ؑ�q��I����Jʚ�;�䃳�W8�nqpn�]�7Z4�qæs31Ml�� �R5��*�x�lƠ�����W���L�W{{�x���Ėn�ӂ��=��?Uy-e���R샴���hc`ә�~�q _4=S�ivd�lC�x]�S�DVB^�\�ׯ�-��K�h�~z7��`�XZ��O�_�/:h;l��٣�z��*��2�P�O���v�>E�<���YF�k	m?�6�֔����>KJ!ʻ�{�e��΄G         5  x�5�AN�0EדS�Q;�٥XT�Rٰ�6�֪c�7�����pZ������?8[�������M�q;����wE���N������Q5�Z+����R5k1�%b�'��
���}Ǜh�[��[s�Ѥ��.jQ(Qi-�L@�Y�}��I��Y�lm���`�hb��T66�t�e���Zs�*Y�E&Ae�0�d-[�h�5���?�&����C'��k1�aOt���JA�J^�7"��F���:
lf��s�����B�=:�t;:�'��Dr����\\p���Y��7M         {   x�3202�54�52�41LALC4000�<���r��ĢĪ�.�
C�b�A�M8��r��́0��� !�*K�*��� ����,8�KSJ���f���@���a��	�Ȫb���� ��1&     